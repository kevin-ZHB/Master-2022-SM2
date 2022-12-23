package data;

import java.io.Serializable;

/**
 * Class Application is a subclass of Class ApplicationFile that implements
 * interface Data which managing a single application data
 * 
 * @see ApplicationFile
 * 
 * @author Hongbo Zhou
 */
public class Application extends ApplicationFile implements Data, Serializable {

    /**
     * Index of createAt.
     */
    protected String createAt;

    /**
     * Index of lastname.
     */
    protected String lastname;

    /**
     * Index of firstname.
     */
    protected String firstname;

    /**
     * Index of career summary.
     */
    protected String careerSummary;

    /**
     * Index of age.
     */
    protected String age;

    /**
     * Index of gender.
     */
    protected String gender;

    /**
     * Index of highest degree.
     */
    protected String highestDegree;

    /**
     * Index of comp90041.
     */
    protected String comp90041;

    /**
     * Index of comp90038.
     */
    protected String comp90038;

    /**
     * Index of comp90007.
     */
    protected String comp90007;

    /**
     * Index of info90002.
     */
    protected String info90002;

    /**
     * Index of salary expectations.
     */
    protected String salaryExpectations;

    /**
     * Index of availability.
     */
    protected String availability;

    /**
     * Index of wam.
     */
    protected double wam;

    /**
     * List of values in this application.
     */
    protected String[] values;

    
    /**
     * Class of this data
     */
    public String type = "application";
    /**
     * Class constructor specifying data values.
     * 
     * @param values the list of values of this application
     */
    public Application(String[] values) {
        this.values = values;
        assignValue(values);
        calculateWam();
    }

    /**
     * Class constructor.
     */
    public Application() {
        super();
    }

    /**
     * Get values of this application.
     * 
     * @return values of this application
     */
    public String[] getValues() {
        return values;
    }

    /**
     * Set values of this application
     * 
     * @param values values of this application
     */
    public void setValues(String[] values) {
        this.values = values;
    }

    /**
     * Get value of wam.
     * 
     * @return values of wam
     */
    public double getWam() {
        return wam;
    }

    /**
     * Set value of wam
     * 
     * @param wam value of wam
     */
    public void setWam(double wam) {
        this.wam = wam;
    }

    /**
     * Get value of type.
     * 
     * @return values of type
     */
    public String getType() {
        return type;
    }

    /**
     * Set value of type.
     * 
     * @param type value of type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get value of createAt.
     * 
     * @return values of createAt
     */
    public String getCreateAt() {
        if (this.createAt.equals("")) {
            return "n/a";
        }
        return createAt;
    }

    /**
     * Set value of createAt.
     * 
     * @param createAt value of createAt
     */
    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    /**
     * Get value of lastname.
     * 
     * @return values of lastname
     */
    public String getLastname() {
        if (this.lastname.equals("")) {
            return "n/a";
        }
        return lastname;
    }

    /**
     * Set value of lastname.
     * 
     * @param lastname value of lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Get value of firstname.
     * 
     * @return values of firstname
     */
    public String getFirstname() {
        if (this.firstname.equals("")) {
            return "n/a";
        }
        return firstname;
    }

    /**
     * Set value of firstname.
     * 
     * @param firstname value of firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Get value of full name.
     * 
     * @return value of full name
     */
    public String getName() {
        String name = this.lastname + " " + this.firstname;
        return name;
    }

    /**
     * Get value of career summary.
     * 
     * @return value of career summary
     */
    public String getCareerSummary() {
        if (this.careerSummary.equals("")) {
            return "n/a";
        }
        return careerSummary;
    }

    /**
     * Set value of career summary.
     * 
     * @param careerSummary value of career summary
     */
    public void setCareerSummary(String careerSummary) {
        this.careerSummary = careerSummary;
    }

    /**
     * Get value of age.
     * 
     * @return value of age
     */
    public String getAge() {
        if (this.age.equals("")) {
            return "n/a";
        }
        return age;
    }

    /**
     * Set value of age.
     * 
     * @param age value of age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * Get value of gender.
     * 
     * @return value of gender
     */
    public String getGender() {
        if (this.gender.equals("")) {
            return "n/a";
        }
        return gender;
    }

    /**
     * Set value of gender.
     * 
     * @param gender value of gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Get value of highest degree.
     * 
     * @return value of highest degree
     */
    public String getHighestDegree() {
        if (this.highestDegree.equals("")) {
            return "n/a";
        }
        return highestDegree;
    }

    /**
     * Set value of highest degree.
     * 
     * @param highestDegree value of highest degree
     */
    public void setHighestDegree(String highestDegree) {
        this.highestDegree = highestDegree;
    }

    /**
     * Get value of COMP90041.
     * 
     * @return value of COMP90041
     */
    public String getComp90041() {
        if (this.comp90041.equals("")) {
            return "n/a";
        }
        return comp90041;
    }

    /**
     * Set value of COMP90041.
     * 
     * @param comp90041 value of COMP90041
     */
    public void setComp90041(String comp90041) {
        this.comp90041 = comp90041;
    }

    /**
     * Get value of COMP90038.
     * 
     * @return value of COMP90038
     */
    public String getComp90038() {
        if (this.comp90038.equals("")) {
            return "n/a";
        }
        return comp90038;
    }

    /**
     * Set value of COMP90038.
     * 
     * @param comp90038 value of COMP90038
     */
    public void setComp90038(String comp90038) {
        this.comp90038 = comp90038;
    }

    /**
     * Get value of COMP90007.
     * 
     * @return value of COMP9007
     */
    public String getComp90007() {
        if (this.comp90007.equals("")) {
            return "n/a";
        }
        return comp90007;
    }

    /**
     * Set value of COMP9007.
     * 
     * @param comp90007 value of COMP9007
     */
    public void setComp90007(String comp90007) {
        this.comp90007 = comp90007;
    }

    /**
     * Get value of INFO90002.
     * 
     * @return value of INFO90002
     */
    public String getInfo90002() {
        if (this.info90002.equals("")) {
            return "n/a";
        }
        return info90002;
    }

    /**
     * Set value of INFO90002.
     * 
     * @param info90002 value of INFO90002
     */
    public void setInfo90002(String info90002) {
        this.info90002 = info90002;
    }

    /**
     * Get value of salary expectations.
     * 
     * @return value of salary expectations
     */
    public String getSalaryExpectations() {
        if (this.salaryExpectations.equals("")) {
            return "n/a";
        }
        return salaryExpectations;
    }

    /**
     * Set value of salary expectations
     * @param salaryExpectations value of salary expectations
     */
    public void setSalaryExpectations(String salaryExpectations) {
        this.salaryExpectations = salaryExpectations;
    }

    /**
     * Get value of available date.
     * 
     * @return value of available date
     */
    public String getAvailability() {
        if (this.availability.equals("")) {
            return "n/a";
        }
        return availability;
    }

    /**
     * Set value of availability
     * @param availability value of availability
     */
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    /**
     * Set value of name
     * @param name value of anme
     * @param type firstname or lastanme
     */
    public void setName(String name, String type) {

        switch (type) {
            case "Lastname":
                setLastname(name);
                break;
            case "Firstname":
                setFirstname(name);
                break;

        }
    }

    /**
     * Set value of four courseworks
     * @param grade value of greade
     * @param type name of the coursework
     */
    public void setCourseWork(String grade, String type) {
        switch (type) {
            case "COMP90041":
                setComp90041(grade);
                break;
            case "COMP90038":
                setComp90038(grade);
                break;
            case "COMP90007":
                setComp90007(grade);
                break;
            case "INFO90002":
                setInfo90002(grade);
                break;
        }
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

                case LASTNAME:
                    this.lastname = value;
                    break;

                case FIRSTNAME:
                    this.firstname = value;
                    break;

                case CAREERSUMMARY:
                    this.careerSummary = value;
                    break;

                case AGE:
                    this.age = value;
                    break;

                case GENDER:
                    this.gender = value;
                    break;
                case HIGHESTDEGREE:
                    this.highestDegree = value;
                    break;

                case COMP90041:
                    this.comp90041 = value;
                    break;

                case COMP90038:
                    this.comp90038 = value;
                    break;

                case COMP90007:
                    this.comp90007 = value;
                    break;

                case INFO90002:
                    this.info90002 = value;
                    break;

                case SALARYEXPECTATION:
                    this.salaryExpectations = value;
                    break;

                case AVAILABILITY:
                    this.availability = value;
                    break;
            }
        }

    }

    /**
     * Calculate wam of four courseworks
     */
    private void calculateWam() {
        double total = 0.0;
        int num = 0;
        if (!this.comp90041.equals("")) {
            total += Double.parseDouble(this.comp90041);
            num += 1;
        }
        if (!this.comp90038.equals("")) {
            total += Double.parseDouble(this.comp90038);
            num += 1;
        }
        if (!this.comp90007.equals("")) {
            total += Double.parseDouble(this.comp90007);
            num += 1;
        }
        if (!this.info90002.equals("")) {
            total += Double.parseDouble(this.info90002);
            num += 1;
        }
        if (num > 0) {
            this.wam = total / num;

        } else {
            this.wam = 0;
        }
    }

    /**
     * Deep clone a new application object with same values.
     * 
     */
    public Application clone() {
        return new Application(this.getValues());
    }

}
