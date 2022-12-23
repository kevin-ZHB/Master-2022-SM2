package data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import exception.InvalidCharacteristicException;
import exception.InvalidDataFormatException;
import exception.NumberFormatException;

import java.io.*;

/**
 * Class JobFile is a subclass of Class DataFile for managing data of Class
 * Application
 * 
 * @see DataFile
 * @author HongboZhou
 */
public class JobFile extends DataFile implements Serializable {

    /**
     * Index of createAt.
     */
    protected final static int CREATEAT = 0;

    /**
     * Index of title.
     */
    protected final static int TITLE = 1;

    /**
     * Index of description.
     */
    protected final static int DESCRIPTION = 2;

    /**
     * Index of degree.
     */
    protected final static int DEGREE = 3;

    /**
     * Index of salary.
     */
    protected final static int SALARY = 4;

    /**
     * Index of start date.
     */
    protected final static int STARTDATE = 5;

    /**
     * List of indexes that should be in int type.
     */
    protected final static int[] INTVALUE = { CREATEAT };

    /**
     * List of indexes that should be in double type.
     */
    protected final static int[] DOUBLEVALUE = { CREATEAT, SALARY };

    /**
     * List of indexes that should be in string type.
     */
    protected final static int[] STRINGVALUE = { TITLE, DESCRIPTION, DEGREE };

    /**
     * List of indexes that are mandatory.
     */
    protected final static int[] MANDATORY = { TITLE, STARTDATE };

    /**
     * List of supported degree.
     */
    protected final static ArrayList<String> DEGREEVALUE = new ArrayList<>(Arrays.asList("Bachelor", "Master", "PHD"));
    /**
     * Valid salary lower bound
     */
    protected final static int SALARYLOWERBOUND = 0;

    /**
     * List of all jobs
     */
    protected ArrayList<Job> jobs = new ArrayList<>();
    /**
     * List of all applied jobs
     */
    protected ArrayList<Job> appliedJobs = new ArrayList<>();
    /**
     * Total number of applicants for all jobs
     */
    protected int numApplicants = 0;

    /**
     * Class constructor specifying file path and user role.
     * 
     * @param path the path where the file is stroed
     * @param role the user role
     */
    public JobFile(String path, String role) {
        super(path, "jobs", role);
        loadFile();
        countNumber();
        countApplicants();
    }

    /**
     * Class constructor
     */
    public JobFile() {
    }

    /**
     * Get total number of applicants for all jobs
     * 
     * @return total number of applicants for all jobs
     */
    public int getNumApplicants() {
        return numApplicants;
    }

    /**
     * Set the total number of applicants for all jobs
     * 
     * @param numApplicants total number of applicants for all jobs
     */
    public void setNumApplicants(int numApplicants) {
        this.numApplicants = numApplicants;
    }

    /**
     * Get list of all jobs
     * @return list of all jobs
     */
    public ArrayList<Job> getJobs() {
        return jobs;
    }

    /**
     * Get list of all applied jobs
     * @return list of all applied jobs
     */
    public ArrayList<Job> getAppliedJobs() {
        return appliedJobs;
    }

    /**
     * Add new job to the applied job list
     * @param job new applied job
     */
    public void addAppliedJob(Job job) {
        this.appliedJobs.add(job);
    }

    /*
     * (non-Javadoc)
     * 
     * @see DataFile#createData(java.lang.String, int)
     */
    @Override
    public void createData(String text, int numLine) {
        String[] values = cleanData(text);

        try {
            checkDataFormat(values);
            checkNumberFormat(values, numLine, INTVALUE, DOUBLEVALUE, STRINGVALUE, MANDATORY);
            checkCharacteristic(values, numLine);

        } catch (InvalidDataFormatException e1) {
            displayInvalidDataFormatMessage(super.type, numLine);
        } catch (NumberFormatException e2) {
            displayInvalidNumberFormatMessage(super.type, numLine);
        } catch (InvalidCharacteristicException e3) {
            displayInvalidCharacteristicMessage(super.type, numLine);
        }

        Job newJob = new Job(values);
        createApplicantsFile(newJob);
        this.jobs.add(newJob);
        newJob.loadApplicants();

    }

    /**
     * Create a binary file for storing applicants of the target job.
     * 
     * @param job the target job
     * @see Job
     */
    private void createApplicantsFile(Job job) {
        String path = DEFAULTJOBAPPLICATIONPATH + "/" + job.createAt + ".dat";
        File file = new File(path);

        if (!file.exists()) {
            try {
                file.createNewFile();

            } catch (IOException e) {
                System.err.println(e);
            }
        }

    }

    /**
     * Add a new applicant for the target job.
     * 
     * @param job         the target job for applying
     * @param application the applicant
     * @see Job
     * @see Application
     */
    public void addNewApplicant(Job job, Application application) {
        job.addApplicants(application);
        ObjectOutputStream outputStream = null;
        String path = DEFAULTJOBAPPLICATIONPATH + "/" + job.createAt + ".dat";

        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(path, true));
            outputStream.writeObject(application);
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file.");
        } catch (IOException e) {
            System.out.println("Could not read from file.");
        }

    }

    /**
     * Count total number of applicants that submitted at least one application.
     */
    private void countApplicants() {
        for (Job job : this.jobs) {
            this.numApplicants += job.getApplicants().size();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see DataFile#checkDataFormat(java.lang.String[])
     */
    @Override
    protected void checkDataFormat(String[] values) throws InvalidDataFormatException {
        if (values.length != JOBNUMVALUES) {
            throw new InvalidDataFormatException();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see DataFile#checkCharacteristic(java.lang.String[], int)
     */
    @Override
    protected void checkCharacteristic(String[] values, int numLine) throws InvalidCharacteristicException {
        boolean errorNonMandatory = false;
        for (int index = 0; index < JOBNUMVALUES; index++) {
            if (values[index].equals("")) {
                errorNonMandatory = true;
                continue;
            }
            switch (index) {
                case DEGREE:
                    if (isInvalidHighestDegree(values[index])) {
                        errorNonMandatory = true;
                    }
                    break;
                case SALARY:
                    if (isInvalidSalary(values[index])) {
                        errorNonMandatory = true;
                    }
                    break;
                case STARTDATE:
                    if (isInvalidStartDate(values[index])) {
                        throw new InvalidCharacteristicException();
                    }
                    break;

            }
        }
        try {
            if (errorNonMandatory) {
                throw new InvalidCharacteristicException();
            }
        } catch (InvalidCharacteristicException e) {
            if (!super.role.equals("audit")) {
                System.err.println("WARNING: invalid number format in " + this.type + " file in line " + numLine);

            }

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see DataFile#countNumber()
     */
    @Override
    protected void countNumber() {
        super.numCollection = jobs.size();
    }

    /**
     * Add a new Job object into the file.
     * 
     * @param job the new Job object
     */
    public void addNewData(Job job) {
        this.jobs.add(job);
        saveData(job);
        countNumber();

    }

    /*
     * (non-Javadoc)
     * 
     * @see DataFile#joinString(Data)
     */
    @Override
    protected <T extends Data> ArrayList<String> joinString(T data) {
        ArrayList<String> values = new ArrayList<>();

        values.add(((Job) data).createAt);
        values.add(((Job) data).title);
        values.add(((Job) data).description);
        values.add(((Job) data).degree);
        values.add(((Job) data).salary);
        values.add(((Job) data).startDate);

        return values;
    }

    /**
     * Check if the salary is invalid
     * 
     * @param value the input salary
     * @return true if the salary is invalid. Otherwise, false
     */
    public boolean isInvalidSalary(String value) {
        int salary = Integer.parseInt(value);
        if (salary < SALARYLOWERBOUND) {
            return true;
        }
        return false;
    }

    /**
     * Check if the start date is invalid
     * 
     * @param value the input start date
     * @return true if the start date is invalid. Otherwise, false.
     */
    public boolean isInvalidStartDate(String value) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        formatter.setLenient(false);
        try {
            formatter.parse(value);
            return false;
        } catch (ParseException e) {
            return true;
        }
    }

}
