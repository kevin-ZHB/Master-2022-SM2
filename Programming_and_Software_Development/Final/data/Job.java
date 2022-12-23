package data;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Class job is a subclass of Class JobFile that implements interface Data
 * which manage a single job data.
 * 
 * @see JobFile
 * 
 * @author Hongbo Zhou
 */
public class Job extends JobFile implements Data {

    /**
     * Value of createAt
     */
    protected String createAt;

    /**
     * Value of title
     */
    protected String title;

    /**
     * Value of description
     */
    protected String description;

    /**
     * Value of degree
     */
    protected String degree;

    /**
     * Value of salary
     */
    protected String salary;

    /**
     * Value of startDate
     */
    protected String startDate;

    /**
     * Value of type
     */
    public String type = "job";

    /**
     * List of all applicants for this job
     */
    protected ArrayList<Application> applicants = new ArrayList<>();

    /**
     * Class constructor specifying data values.
     * 
     * @param values the list of values of this job
     */
    public Job(String[] values) {

        assignValue(values);
    }

    /**
     * Class constructor
     */
    public Job() {

    }

    /**
     * Get list of applicants for this job
     * 
     * @return list of applicants for this job
     */
    public ArrayList<Application> getApplicants() {
        return applicants;
    }

    /**
     * Set list of applicants for this job
     * 
     * @param applicants list of applicants for this job
     * @see Application
     */
    public void setApplicants(ArrayList<Application> applicants) {
        this.applicants = applicants;
    }

    /**
     * Add a new applicant
     * 
     * @param application new applicant
     * @see Application
     */
    public void addApplicants(Application application) {
        this.applicants.add(application);
    }

    /**
     * Get value of createAt.
     * 
     * @return value of createAt
     */
    public String getCreateAt() {
        if (this.createAt.equals("")) {
            return "n/a";
        }
        return createAt;
    }

    /**
     * Set value of createAt.
     * @param createAt value of createAt
     */
    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    /**
     * Get value of title
     * @return value of title
     */
    public String getTitle() {
        if (this.title.equals("")) {
            return "n/a";
        }
        return title;
    }

    /**
     * Set value of title
     * @param title value of title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get value of position description
     * @return value of position description
     */
    public String getDescription() {
        if (this.description.equals("")) {
            return "n/a";
        }
        return description;
    }
    /**
     * Set value of position description
     * @param description value of position description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get value of degree
     * @return value of degree
     */
    public String getDegree() {
        if (this.degree.equals("")) {
            return "n/a";
        }
        return degree;
    }

    /**
     * Set value of degree
     * @param degree value of degree
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }

    /**
     * Get value of salary
     * @return value of salary
     */
    public String getSalary() {
        if (this.salary.equals("")) {
            return "n/a";
        }
        return salary;
    }

    /**
     * Set value of salary
     * @param salary value of salary
     *
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * Get value of start date
     * @return value of start date
     */
    public String getStartDate() {
        if (this.startDate.equals("")) {
            return "n/a";
        }
        return startDate;
    }

    /**
     * Set value of start date
     * @param startDate value of start date
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Data#assignValue(java.lang.String[])
     */
    public void assignValue(String[] values) {
        for (int index = 0; index < values.length; index++) {
            String value = values[index];
            switch (index) {
                case CREATEAT:
                    this.createAt = value;
                    break;

                case TITLE:
                    this.title = value;
                    break;

                case DESCRIPTION:
                    this.description = value;
                    break;

                case DEGREE:
                    this.degree = value;
                    break;

                case SALARY:
                    this.salary = value;
                    break;

                case STARTDATE:
                    this.startDate = value;
                    break;

            }
        }

    }

    /**
     * Load all applicants for this job.
     * 
     * @see Application
     */
    protected void loadApplicants() {
        String path = DEFAULTJOBAPPLICATIONPATH + "/" + this.createAt + ".dat";
        ObjectInputStream inputStream = null;
        Application application;

        try {
            inputStream = new ObjectInputStream(new FileInputStream(path));
            while (true) {

                application = (Application) inputStream.readObject();
                applicants.add(application);

            }

        } catch (EOFException e) {

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
