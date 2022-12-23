package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import exception.InvalidCharacteristicException;
import exception.InvalidDataFormatException;
import exception.NumberFormatException;

/**
 * Class ApplicationFile is a subclass of Class DataFile for managing data of
 * Class Application
 * @see DataFile
 * @author Hongbo Zhou
 */
public class ApplicationFile extends DataFile {

    /**
     * Index of createAt.
     */
    protected final static int CREATEAT = 0;
    /**
     * Index of Lastname.
     */
    protected final static int LASTNAME = 1;
    /**
     * Index of firstname.
     */
    protected final static int FIRSTNAME = 2;
    /**
     * Index of career summary.
     */
    protected final static int CAREERSUMMARY = 3;
    /**
     * Index of age.
     */
    protected final static int AGE = 4;
    /**
     * Index of gender.
     */
    protected final static int GENDER = 5;
    /**
     * Index of highest degree.
     */
    protected final static int HIGHESTDEGREE = 6;
    /**
     * Index of COMP90041.
     */
    protected final static int COMP90041 = 7;
    /**
     * Index of COMP90038.
     */
    protected final static int COMP90038 = 8;
    /**
     * Index of COMP90007.
     */
    protected final static int COMP90007 = 9;
    /**
     * Index of INFO90002.
     */
    protected final static int INFO90002 = 10;
    /**
     * Index of salary expectation.
     */
    protected final static int SALARYEXPECTATION = 11;
    /**
     * Index of availability.
     */
    protected final static int AVAILABILITY = 12;

    /**
     * List of indexes that should be in double type.
     */
    protected final static int[] DOUBLEVALUE = { COMP90041, COMP90038, COMP90007, INFO90002, SALARYEXPECTATION };
    /**
     * List of indexes that should be in int type.
     */
    protected final static int[] INTVALUE = { CREATEAT, AGE };
    /**
     * List of indexes that should be in string type.
     */
    protected final static int[] STRINGVALUE = { LASTNAME, FIRSTNAME, CAREERSUMMARY, GENDER, HIGHESTDEGREE,
            AVAILABILITY };
            /**
     * List of indexes that are mandatory.
     */
    protected final static int[] MANDATORY = { LASTNAME, FIRSTNAME, AGE };

    /**
     * List of supported gender
     */
    protected final static ArrayList<String> GENDERVALUE = new ArrayList<>(Arrays.asList("female", "male", "other"));

    /**
     * Valid age lower bound
     */
    protected final static int AGELOWERBOUND = 18;
    /**
     * Valid age upper bound
     */
    protected final static int AGEUPPERBOUND = 100;
    /**
     * Valid grade lower bound
     */
    protected final static int GRADELOWERBOUND = 49;
    /**
     * Valid grade upper bound
     */
    protected final static int GRADEUPPERBOUND = 100;
    /**
     * Valid salary lower bound
     */
    protected final static int SALARYLOWERBOUND = 0;

    /**
     * List of all applications
     */
    public ArrayList<Application> applications = new ArrayList<>();

    /**
     * Class constructor specifying file path and user role.
     * @param path the path where the file is stored
     * @param role the user role
     */
    public ApplicationFile(String path, String role) {
        super(path, "applications", role);
        loadFile();
        countNumber();
    }


    /**
     * Class constructor
     */
    public ApplicationFile() {
    }

    /**
     * Get all applications
     * @return list of applications
     */
    public ArrayList<Application> getApplications() {

        return applications;
    }

    /* (non-Javadoc)
     * @see DataFile#createData(java.lang.String, int)
     */
    @Override
    protected void createData(String text, int numLine) {
        String[] values = cleanData(text);
        try {
            checkDataFormat(values);
            checkNumberFormat(values, numLine, INTVALUE, DOUBLEVALUE, STRINGVALUE, MANDATORY);
            checkCharacteristic(values, numLine);

        } catch (InvalidDataFormatException e1) {
            if (!super.role.equals("audit")) {
                displayInvalidDataFormatMessage(super.type, numLine);
            }
        } catch (NumberFormatException e2) {
            if (!super.role.equals("audit")) {
                displayInvalidNumberFormatMessage(super.type, numLine);
            }
        } catch (InvalidCharacteristicException e3) {
            if (!super.role.equals("audit")) {
                displayInvalidCharacteristicMessage(super.type, numLine);

            }
        }

        this.applications.add(new Application(values));
    }

    /* (non-Javadoc)
     * @see DataFile#checkDataFormat(java.lang.String[])
     */
    @Override
    protected void checkDataFormat(String[] values) throws InvalidDataFormatException {

        if (values.length != APPLICATIONNUMVALUES) {
            throw new InvalidDataFormatException();
        }

    }

    /* (non-Javadoc)
     * @see DataFile#checkCharacteristic(java.lang.String[], int)
     */
    @Override
    protected void checkCharacteristic(String[] values, int numLine) throws InvalidCharacteristicException {
        boolean errorNonMandatory = false;
        for (int index = 0; index < APPLICATIONNUMVALUES; index++) {

            switch (index) {
                case AGE:
                    if (isInvalidAge(values[index])) {
                        throw new InvalidCharacteristicException();
                    }
                    break;
                case GENDER:
                    if (isInvalidGender(values[index])) {
                        errorNonMandatory = true;
                    }
                    break;
                case HIGHESTDEGREE:
                    if (isInvalidHighestDegree(values[index])) {
                        errorNonMandatory = true;
                    }
                    break;
                case COMP90007:
                case COMP90038:
                case COMP90041:
                case INFO90002:
                    if (isInvalidCourseWork(values[index])) {
                        errorNonMandatory = true;
                    }
                    break;
                case SALARYEXPECTATION:
                    if (isInvalidSalaryExpection(values[index])) {
                        errorNonMandatory = true;
                    }
                    break;

                case AVAILABILITY:
                    if (isInvalidDate(values[index])) {
                        errorNonMandatory = true;

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
                System.err.println("WARNING: invalid characteristic in " + this.type + " file in line " + numLine);
            }

        }

    }

    /* (non-Javadoc)
     * @see DataFile#countNumber()
     */
    @Override
    protected void countNumber() {
        super.numCollection = applications.size();
    }

    /**
     * Add a new Application object into the file.
     * @param application the new Application object
     */
    public void addNewData(Application application) {
        this.applications.add(application);
        saveData(application);
        countNumber();

    }

    /* (non-Javadoc)
     * @see DataFile#joinString(Data)
     */
    @Override
    protected <T extends Data> ArrayList<String> joinString(T data) {
        ArrayList<String> values = new ArrayList<>();

        values.add(((Application) data).createAt);
        values.add(((Application) data).lastname);
        values.add(((Application) data).firstname);
        values.add(((Application) data).careerSummary);
        values.add(((Application) data).age);
        values.add(((Application) data).gender);
        values.add(((Application) data).highestDegree);
        values.add(((Application) data).comp90041);
        values.add(((Application) data).comp90038);
        values.add(((Application) data).comp90007);
        values.add(((Application) data).info90002);
        values.add(((Application) data).salaryExpectations);
        values.add(((Application) data).availability);

        return values;
    }

    /**
     * Check if the age is invalid
     * @param value the input age
     * @return true if the age is invalid. Otherwise, false.
     */
    public boolean isInvalidAge(String value) {
        if (value.equals("")) {
            return true;
        }
        int age;
        try {
            age = Integer.parseInt(value);
        } catch (Exception e) {
            return true;
        }
        if (age <= AGELOWERBOUND || age >= AGEUPPERBOUND) {
            return true;
        }
        return false;
    }

    /**
     * Check if the gender is invalid
     * @param value the input gender
     * @return true if the gender is invalid. Otherwise, false.
     */
    public boolean isInvalidGender(String value) {
        if (value.equals("")) {
            return true;
        }

        if (!GENDERVALUE.contains(value)) {
            return true;
        }
        return false;
    }

    /**
     * Check if the grade of courseworks is invalid
     * @param value the input grade
     * @return true if the grade is invalid. Otherwise, false.
     */
    public boolean isInvalidCourseWork(String value) {
        if (value.equals("")) {
            return true;
        }
        int grade;
        try {
            grade = Integer.parseInt(value);
        } catch (Exception e) {
            return true;
        }
        if (grade < GRADELOWERBOUND || grade > GRADEUPPERBOUND) {
            return true;
        }
        return false;
    }


    /**
     * Check if the salary expectation is invalid
     * @param value the input salary expectation
     * @return true if the salary expectation is invalid. Otherwise, false.
     */
    public boolean isInvalidSalaryExpection(String value) {
        if (value.equals("")) {
            return true;
        }
        int salary;
        try {
            salary = Integer.parseInt(value);
        } catch (Exception e) {
            return true;
        }
        if (salary < SALARYLOWERBOUND) {
            return true;
        }
        return false;
    }


    /**
     * Check if the available date is invalid
     * @param value the input available date
     * @return true if the available date is invalid. Otherwise, false.
     */
    public boolean isInvalidDate(String value) {
        if (value.equals("")) {
            return true;
        }

        if (isInvalidDateFormat(value)) {
            return true;
        }

        Date now = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        formatter.setLenient(false);
        try {
            Date date = formatter.parse(value);
            if (date.after(now)) {
                return false;
            }
            return true;

        } catch (ParseException e) {
            return true;
        }
    }

}
