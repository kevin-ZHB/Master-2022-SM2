import java.io.File;
import java.util.*;

import data.Application;
import data.ApplicationFile;
import data.Data;
import data.Job;
import data.JobFile;


/**
 * Class AssistantSystem is the class that holds majory methods to deal with
 * command line arguments and further commands.
 * 
 * @author Hongbo Zhou
 */
public class AssistantSystem {

    /**
     * The list of supported user role.
     */
    private final static String[] USERROLE = { "hr", "applicant", "audit" };
    /**
     *Default applications file path.
     */
    private final static String DEFAULTAPPLICATIONPATH = "applications.csv";
    /**
     * Default job file path.
     */
    private final static String DEFAULTJOBPATH = "jobs.csv";
    /**
     * Default folder for applicants of each job.
     */
    private final static String DEFAULTJOBAPPLICANTPATH = "./data/JobApplicant";
    /**
     * The list of mandatory field for an application.
     */
    private final static String[] APPGENERALMANDATORYFIELD = { "Lastname", "Firstname" };
    /**
     * The list of specified field for an application.
     */
    private final static String[] APPGENERALSPECIFIEDFIELD = { "Gender", "Highest Degree", "Coursework",
            "Salary Expectations ($ per annum)", "Availability" };
    /**
     * The list of mandatory field for an job.
     */
    private final static String[] JOBGENERALMANDATORYFIELD = { "Position Title" };
    /**
     * The list of specified field for an job.
     */
    private final static String[] JOBGENERALSPECIFIEDFIELD = { "Minimum Degree Requirement", "Salary ($ per annum)",
            "Start Date" };

    /**
     * The user role.
     */
    private String role;
    /**
     * The ApplicationFile object stored all Application object.
     * @see ApplicationFile
     */
    private ApplicationFile applicationFile;
    /**
     * The path of the application file .
     */
    private String applicationFilePath = DEFAULTAPPLICATIONPATH;
    /**
     * The JobFile object stored all Job object.
     */
    private JobFile jobFile;
    /**
     * The path of the job file.
     */
    private String jobFilePath = DEFAULTJOBPATH;

    /**
     * The new application profile for applicant system.
     */
    private Application newApplication = null;


    /**
     * Class constructor specifying command line arguments
     * @param args command line arguments
     */
    public AssistantSystem(String[] args) {
        setUp(args);

    }

    /**
     * Get the new application object.
     * @return an Application object
     */
    public Application getNewApplication() {
        return newApplication;
    }

    /**
     * Set the new application object by given application object
     * @param newApplication the new application object 
     */
    public void setNewApplication(Application newApplication) {
        this.newApplication = newApplication;
    }

    /**
     * Get the user role.
     * @return String of user role
     */
    public String getRole() {
        return role;
    }

    /**
     * Set the user role.
     * @param role the input user role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Get the ApplicationFile object.
     * @return ApplicationFile object
     * @see ApplicationFile
     */
    public ApplicationFile getApplicationFile() {
        return applicationFile;
    }

    /**
     * Create and Set the ApplicationFile object specifying the path of the application file.
     * @param path the path of the application file.
     */
    public void setApplicationFile(String path) {
        this.applicationFile = new ApplicationFile(path, this.role);
    }

    /**
     * Get the JobFile object
     * @return JobFile object
     * @see JobFile
     */
    public JobFile getJobFile() {
        return jobFile;
    }

    /**
     * Create and Set the JobFile object specifying the path of the job file
     * @param path the path of the job file
     */
    public void setJobFile(String path) {
        this.jobFile = new JobFile(path, this.role);
    }

    /**
     * Get number of jobs in the job file
     * @return number of jobs
     */
    public int getNumberJobs() {
        return jobFile.getNumCollection();
    }

    /**
     * Get number of available jobs for this applicant
     * @return number of available jobs
     */
    public int getNumberAvailableJobs() {
        return jobFile.getJobs().size() - jobFile.getAppliedJobs().size();
    }

    /**
     * Get number of applied jobs for this applicant
     * @return number of applied jobs 
     */
    public int getNumberAppliedJobs() {
        return jobFile.getAppliedJobs().size();
    }

    /**
     * Get total number of applicants for all jobs 
     * @return number of applicants for all jobs
     */
    public int getNumberApplicants() {
        return jobFile.getNumApplicants();
    }

    /**
     * Initialize this assistant system according to command line arguments.
     * 
     * @param args the arguments input when starting the program
     */
    private void setUp(String[] args) {
        // Check if role is defined.
        if (!Arrays.asList(args).contains("-r") && !Arrays.asList(args).contains("--role")
                && !Arrays.asList(args).contains("--help") && !Arrays.asList(args).contains("-h")) {
            System.out.println("Error: no role defined.");
            displayHelpMessage();
        } else {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-h") || args[i].equals("--help")) {
                    displayHelpMessage();
                    break;
                }

                if (args[i].equals("-r") || args[i].equals("--role")) {
                    if (isTheLast(i, args.length)) {
                        System.out.println("Error: no role defined.");
                        displayHelpMessage();
                        break;
                    }

                    String userRole = args[i + 1];
                    if (!Arrays.asList(USERROLE).contains(userRole)) {
                        System.out.println("ERROR: " + userRole + " is not a valid role.");
                        displayHelpMessage();
                        break;
                    }

                    this.role = userRole;
                    i += 1;
                    continue;
                }

                // Check if the flag is set but file is not set
                if (isTheLast(i, args.length)) {
                    displayHelpMessage();
                    break;
                }

                if (args[i].equals("-a") || args[i].equals("--applications")) {

                    String path = args[i + 1];
                    if (isInvalidPath(path)) {
                        System.out.println("WRONG application file path");

                        displayHelpMessage();
                        break;
                    }
                    this.applicationFilePath = path;

                    i += 1;
                    continue;
                }

                if (args[i].equals("-j") || args[i].equals("--jobs")) {
                    String path = args[i + 1];
                    if (isInvalidPath(path)) {
                        System.out.println("WRONG job file path");
                        displayHelpMessage();
                        break;
                    }
                    this.jobFilePath = path;
                    i += 1;
                    continue;
                }

            }

        }

    }

    /**
     * Load Application file and Job file and create files of applicants for each
     * job
     * 
     */
    public void loadFiles() {
        createJobApplicantFolder(DEFAULTJOBAPPLICANTPATH);
        this.applicationFile = new ApplicationFile(this.applicationFilePath, this.role);
        this.jobFile = new JobFile(this.jobFilePath, this.role);
    }

    /**
     * Create a folder for storing applicants files if the folder does not exist.
     * 
     * @param path path for storing applicants files 
     */
    private void createJobApplicantFolder(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }

    }

    /**
     * Create a new application step by step and save the new
     * application to the applications file by appending it to the end of the file
     * 
     * @param stdin the Scanner object for further input.
     * @return the new created application
     */
    private Application createNewApplication(Scanner stdin) {
        System.out.println("# Create new Application");
        Application application = new Application();

        for (String field : APPGENERALMANDATORYFIELD) {
            inputGeneralMandatoryField(application, application.type, field, stdin);
        }

        inputCareerSummary(application, stdin);
        inputAge(application, stdin);

        for (String field : APPGENERALSPECIFIEDFIELD) {
            inputGeneralSpecifiedField(application, application.type, field, stdin);
        }

        application.setCreateAt(createAt());
        return application;
    }

    /**
     * Create a new job step by step and save the new job to the
     * jobs file by appending it to the end of the file
     * 
     * @param stdin the Scanner object for further input.
     * @return the new created job
     * @see Job
     */
    private Job createNewJob(Scanner stdin) {
        System.out.println("# Create new Job");
        Job job = new Job();

        for (String field : JOBGENERALMANDATORYFIELD) {
            inputGeneralMandatoryField(job, job.type, field, stdin);
        }

        inputDescription(job, stdin);

        for (String field : JOBGENERALSPECIFIEDFIELD) {
            inputGeneralSpecifiedField(job, job.type, field, stdin);
        }

        job.setCreateAt(createAt());
        return job;
    }

    /**
     * The function of creating a timestamp of current date
     * 
     * @return the String format timestamp.
     */
    private String createAt() {
        long timestamp = System.currentTimeMillis();
        String createAt = String.valueOf(timestamp / 1000);
        return createAt;
    }

    /**
     * Operate the system for different user role.
     * 
     * @param command the command input by command line
     * @param stdin   the Scanner object for further input.
     */
    public void operate(String command, Scanner stdin) {

        switch (this.role) {
            case "applicant":
                applicantOperate(command, stdin);
                break;
            case "hr":
                hrOperate(command, stdin);
                break;
        }
    }

    /**
     * Operate applicant system
     * 
     * @param command the command input by command line
     * @param stdin   the Scanner object for further input
     */
    private void applicantOperate(String command, Scanner stdin) {
        switch (command) {
            case "create":
            case "c":
                this.newApplication = createNewApplication(stdin);
                applicationFile.addNewData(this.newApplication);
                returnToMenu();
                break;
            case "jobs":
            case "j":
                listAvailableJobs();
                if (this.newApplication != null) {
                    applyJobs(stdin);
                }

                returnToMenu();
                break;

            default:
                System.out.println("Invalid input! Please enter a valid command to continue: ");
        }
    }

    /**
     * Operate hr system
     * 
     * @param command the command input by command line
     * @param stdin   the Scanner object for further input
     */
    private void hrOperate(String command, Scanner stdin) {
        switch (command) {
            case "create":
            case "c":
                jobFile.addNewData(createNewJob(stdin));
                returnToMenu();
                break;
            case "jobs":
            case "j":
                listAllJobs();
                returnToMenu();
                break;
            case "applicants":
            case "a":
                listAllApplicants(this.applicationFile.getApplications());
                returnToMenu();
                break;
            case "filter":
            case "f":
                filterApplications(stdin);
                returnToMenu();
                break;
            case "match":
            case "m":
                matchApplications();
                returnToMenu();

                break;
            default:
                System.out.println("Invalid input! Please enter a valid command to continue: ");

        }
    }

    /**
     * Operate audit system.
     * @see Matchmaker
     */
    public void auditOperate() {
        displayAuditMenuMessage();
        Matchmaker matchmaker = new Matchmaker(this.jobFile.getJobs(), this.applicationFile.getApplications());
        matchmaker.displayAuditStatistic();
        System.exit(0);
    }

    /**
     * Set description for a job object.
     * 
     * @param job   the target job object
     * @param stdin the Scanner object for further input
     * @see Job
     */
    private void inputDescription(Job job, Scanner stdin) {

        System.out.print("Position Description: ");
        job.setDescription(stdin.nextLine());
    }

    /**
     * Set minimum required degree for a job object.
     * 
     * @param job   the target job object
     * @param stdin the Scanner object for further input
     * @see Job
     */
    private void inputMinimumDegree(Job job, Scanner stdin) {

        String minimumDegree = stdin.nextLine();
        if (!minimumDegree.equals("")) {
            while (job.isInvalidHighestDegree(minimumDegree)) {
                displayInvalidInputMessage("Minimum Degree Requirement");
                minimumDegree = stdin.nextLine();
                if (minimumDegree.equals("")) {
                    break;
                }
            }
        }
        job.setDegree(minimumDegree);
    }

    /**
     * Set salary for a job object.
     * 
     * @param job   the target job object
     * @param stdin the Scanner object for further input
     * @see Job
     */
    private void inputSalary(Job job, Scanner stdin) {
        String salary = stdin.nextLine();
        if (!salary.equals("")) {
            while (job.isInvalidSalary(salary)) {
                displayInvalidInputMessage("Salary ($ per annum) ");
                salary = stdin.nextLine();
                if (salary.equals("")) {
                    break;
                }
            }
        }
        job.setSalary(salary);
    }

    /**
     * Set start date for a job object.
     * 
     * @param job   the target job object
     * @param stdin the Scanner object for further input
     * @see Job
     */
    private void inputStartDate(Job job, Scanner stdin) {
        String startDate = stdin.nextLine();
        if (!startDate.equals("")) {
            while (job.isInvalidStartDate(startDate)) {
                displayInvalidInputMessage("Start Date");
                startDate = stdin.nextLine();
                if (startDate.equals("")) {
                    break;
                }
            }
        }
        job.setStartDate(startDate);
    }

    /**
     * Set career summary for a application object.
     * 
     * @param application the target applicaiton object.
     * @param stdin       the Scanner object for further input.
     * @see Application
     */
    private void inputCareerSummary(Application application, Scanner stdin) {
        System.out.print("Career Summary: ");
        application.setCareerSummary(stdin.nextLine());
    }

    /**
     * Set age for a application object.
     * 
     * @param application the target applicaiton object.
     * @param stdin       the Scanner object for further input.
     * @see Application
     */
    private void inputAge(Application application, Scanner stdin) {
        System.out.print("Age: ");
        String age = stdin.nextLine();
        while (application.isInvalidAge(age)) {
            System.out.print("Ooops! A valid age between 18 and 100 must be provided: ");
            age = stdin.nextLine();
        }
        application.setAge(age);
    }

    /**
     * Set gender for a application object.
     * 
     * @param application the target applicaiton object.
     * @param stdin       the Scanner object for further input.
     * @see Application
     */
    private void inputGender(Application application, Scanner stdin) {

        String gender = stdin.nextLine();
        if (!gender.equals("")) {
            while (application.isInvalidGender(gender)) {
                displayInvalidInputMessage("Gender");
                gender = stdin.nextLine();
                if (gender.equals("")) {
                    break;
                }
            }
        }

        application.setGender(gender);
    }

    /**
     * Set highest degree for a application object.
     * 
     * @param application the target applicaiton object.
     * @param stdin       the Scanner object for further input.
     * @see Application
     */
    private void inputHighestDegree(Application application, Scanner stdin) {

        String heighestDegree = stdin.nextLine();
        if (!heighestDegree.equals("")) {
            while (application.isInvalidHighestDegree(heighestDegree)) {
                displayInvalidInputMessage("Highest Degree");
                heighestDegree = stdin.nextLine();
                if (heighestDegree.equals("")) {
                    break;
                }
            }
        }

        application.setHighestDegree(heighestDegree);
    }

    /**
     * Set coursework degrees for a application object.
     * 
     * @param application the target applicaiton object.
     * @param stdin       the Scanner object for further input.
     * @see Application
     */

    private void inputCourseWork(Application application, Scanner stdin) {
        boolean comp90041 = false;
        boolean comp90038 = false;
        boolean comp90007 = false;
        boolean info90002 = false;

        System.out.println();
        while (!comp90041 || !comp90038 || !comp90007 || !info90002) {
            String name;
            if (!comp90041) {
                name = "COMP90041";
                comp90041 = true;
            } else if (!comp90038) {
                name = "COMP90038";
                comp90038 = true;

            } else if (!comp90007) {
                name = "COMP90007";
                comp90007 = true;

            } else {
                name = "INFO90002";
                info90002 = true;

            }

            System.out.print("- " + name + ": ");
            String grade = stdin.nextLine();
            if (!grade.equals("")) {
                while (application.isInvalidCourseWork(grade)) {
                    displayInvalidInputMessage(name);
                    grade = stdin.nextLine();
                    if (grade.equals("")) {
                        break;
                    }
                }
            }

            application.setCourseWork(grade, name);
        }
    }

    /**
     * Set salary expectation for a application object.
     * 
     * @param application the target applicaiton object.
     * @param stdin       the Scanner object for further input.
     * @see Application
     */
    private void inputSalaryExpectations(Application application, Scanner stdin) {

        String salary = stdin.nextLine();
        if (!salary.equals("")) {
            while (application.isInvalidSalaryExpection(salary)) {
                displayInvalidInputMessage("Salary Expectations");
                salary = stdin.nextLine();
                if (salary.equals("")) {
                    break;
                }
            }
        }

        application.setSalaryExpectations(salary);
    }

    /**
     * Set available date for a application object.
     * 
     * @param application the target applicaiton object.
     * @param stdin       the Scanner object for further input.
     * @see Application
     */
    private void inputAvailability(Application application, Scanner stdin) {

        String availability = stdin.nextLine();
        if (!availability.equals("")) {
            while (application.isInvalidDate(availability)) {
                displayInvalidInputMessage("Availability");
                availability = stdin.nextLine();
                if (availability.equals("")) {
                    break;
                }
            }
        }

        application.setAvailability(availability);
    }

    /**
     * Set general mandatory data that shares the same pattern of error message for
     * the target object.
     * 
     * @param <T>   generic class for Class Application or Class Job
     * @param data  the target object
     * @param type  the class of the target object, either "application" or "job"
     * @param field the field of the target object to be set
     * @param stdin the Scanner object for further input
     * @see Application
     * @see Job
     */
    private <T extends Data> void inputGeneralMandatoryField(T data, String type, String field, Scanner stdin) {

        System.out.print(field + ": ");
        String input = stdin.nextLine();
        while (input.equals("")) {
            System.out.print("Ooops! " + field + " must be provided: ");
            input = stdin.nextLine();
        }

        switch (type) {
            case "application":

                switch (field) {
                    case "Lastname":
                    case "Firstname":
                        ((Application) data).setName(input, field);
                        break;
                }
                break;
            case "job":
                switch (field) {
                    case "Position Title":
                        ((Job) data).setTitle(input);
                        break;
                }
                break;

        }
    }

    /**
     * Set general not mandatory but specified data that shares the same
     * pattern of error message for the target object.
     * 
     * @param <T>   generic class for Class Application or Class Job
     * @param data  the target object
     * @param type  the class of the target object, either "application" or "job"
     * @param field the field of the target object to be set
     * @param stdin the Scanner object for further input
     * @see Application
     * @see Job
     */
    private <T extends Data> void inputGeneralSpecifiedField(T data, String type, String field, Scanner stdin) {
        System.out.print(field + ": ");

        switch (type) {
            case "application":
                switch (field) {
                    case "Gender":
                        inputGender((Application) data, stdin);
                        break;
                    case "Highest Degree":
                        inputHighestDegree((Application) data, stdin);
                        break;
                    case "Coursework":
                        inputCourseWork((Application) data, stdin);
                        break;
                    case "Salary Expectations ($ per annum)":
                        inputSalaryExpectations((Application) data, stdin);
                        break;
                    case "Availability":
                        inputAvailability((Application) data, stdin);
                        break;

                }
                break;
            case "job":
                switch (field) {
                    case "Minimum Degree Requirement":
                        inputMinimumDegree((Job) data, stdin);
                        break;
                    case "Salary ($ per annum)":
                        inputSalary((Job) data, stdin);
                        break;
                    case "Start Date":
                        inputStartDate((Job) data, stdin);
                        break;

                }
                break;
        }
    }

    /**
     * List all available jobs for this applicant
     * 
     * @see Application
     * @see Job
     */
    private void listAvailableJobs() {
        ArrayList<Job> jobs = jobFile.getJobs();
        ArrayList<Job> appliedJobs = jobFile.getAppliedJobs();
        System.out.println();
        if (jobs.size() == 0) {
            System.out.println("No jobs available.");
        } else {
            int listNum = 1;
            for (Job job : jobs) {
                if (appliedJobs.contains(job)) {
                    continue;
                }
                displayListNum(listNum + "");
                displayJobs(job);
                listNum += 1;
            }
        }

    }

    /**
     * List all jobs that is stroed in the jobs file and list all applications for
     * each job
     * 
     * @see Application
     * @see Job
     * 
     */
    private void listAllJobs() {
        ArrayList<Job> jobs = jobFile.getJobs();
        System.out.println();
        if (jobs.size() == 0) {
            System.out.println("No jobs available");
        } else {
            int listNum = 1;
            for (Job job : jobs) {
                displayListNum(listNum + "");
                displayJobs(job);
                if (job.getApplicants().size() != 0) {
                    char alpha = 'a';
                    int num = 1;
                    String index;
                    if (num > 1) {
                        index = alpha + "" + num;

                    } else {
                        index = alpha + "";
                    }
                    for (Application applicant : job.getApplicants()) {
                        System.out.print("    ");
                        displayListNum(index + "");
                        displayApplicant(applicant);
                        if (alpha < 'z') {
                            alpha += 1;
                        } else {
                            alpha = 'a';
                            num += 1;
                        }
                    }
                }

                listNum += 1;
            }
        }
    }

    /**
     * List all applications in target application list.
     * 
     * @param applications the target application list
     * @see Application
     */
    private void listAllApplicants(ArrayList<Application> applications) {
        System.out.println();
        if (applications.size() == 0) {
            System.out.println("No applicants available.");
        } else {
            int listNum = 1;
            for (Application application : applications) {
                displayListNum(listNum + "");
                displayApplicant(application);
                listNum += 1;
            }
        }
    }

    /**
     * Choose jobs to apply by this applicant
     * 
     * @param stdin Scanner object for further input
     * @see Job
     */
    private void applyJobs(Scanner stdin) {
        System.out.print("Please enter the jobs you would like to apply for (multiple options are possible): ");
        String input = stdin.nextLine();
        while (!input.equals("")) {
            String[] options = input.split(",");
            if (isInvalidApplyOption(options)) {
                System.out.print("Invalid input! Please enter a valid number to continue: ");
                input = stdin.nextLine();

            } else {
                for (String option : options) {
                    Job job = jobFile.getJobs().get(Integer.parseInt(option) - 1);

                    jobFile.addAppliedJob(job);
                    jobFile.addNewApplicant(job, this.newApplication);
                }
                break;
            }

        }

    }

    /**
     * Filter applications according to search criteria.
     * 
     * @param stdin the Scanner object for input search criteria
     * @see Application
     * @see Matchmaker
     */
    private void filterApplications(Scanner stdin) {
        if (applicationFile.getApplications().size() == 0) {
            System.out.println("No applicants available.");
        } else {

            System.out.print("Filter by: [lastname], [degree] or [wam]: ");
            String filter = stdin.nextLine();
            ArrayList<Application> copiedApplications = new ArrayList<>();
            // Copy application list in order to sort without changing original order in the file.
            Matchmaker.deepCopyApplications(copiedApplications, applicationFile.getApplications());
            switch (filter) {
                case "lastname":

                    Matchmaker.lastnameFilter(copiedApplications);
                    break;
                case "degree":
                    Matchmaker.degreeFilter(copiedApplications);
                    break;
                case "wam":
                    Matchmaker.wamFilter(copiedApplications);
                    break;

            }
        }

    }

    /**
     * Match applications for each job
     * 
     * @see Application
     * @see Job
     * @see Matchmaker
     */
    private void matchApplications() {
        Application matchedApplicant;
        if (jobFile.getJobs().size() == 0) {
            System.out.println("No jobs available.");
        } else if (applicationFile.getApplications().size() == 0) {
            System.out.println("No applicants available.");
        } else {

            for (Job job : jobFile.getJobs()) {
                int listNum = 1;
                matchedApplicant = Matchmaker.matchMaking(job, job.getApplicants());
                if (matchedApplicant != null) {
                    displayListNum(listNum + "");
                    displayJobs(job);
                    System.out.print("   Applicant match: ");
                    displayApplicant(matchedApplicant);
                }
            }
        }
    }

    /**
     * Check if the element is the last one in the array.
     * 
     * @param index  index of the current element
     * @param length total number of elements in the array
     * @return true if it is the last element; or flase if it is not the last
     *         element.
     */
    private boolean isTheLast(int index, int length) {
        if (index + 1 == length) {
            return true;
        }

        return false;
    }

    /**
     * Check if the file path is ended with ".csv" suffix.
     * 
     * @param path this file path
     * @return true if the given path is not valid; or flase if the given path is
     *         valid
     */
    private boolean isInvalidPath(String path) {
        if (!path.substring(path.length() - 4, path.length()).equals(".csv")) {
            displayHelpMessage();
            return true;
        }

        return false;
    }

    /**
     * Check if the option to apply is valid.
     * 
     * @param options the list number of jobs
     * @return true if options are not valid; or flase if the options are valid.
     */
    private boolean isInvalidApplyOption(String[] options) {

        for (String option : options) {
            if (!jobFile.isInteger(option)) {
                return true;
            }

            if (Integer.parseInt(option) > this.getNumberAvailableJobs() || Integer.parseInt(option) <= 0) {
                return true;
            }
        }

        return false;
    }

    /**
     * Return to the Menu
     */
    private void returnToMenu() {

        switch (this.role) {
            case "applicant":
                this.displayApplicationMenuMessage();
                break;
            case "hr":
                this.displayHrMenuMessage();

        }
    }

    /**
     * Print fixed help messages and terminate.
     */
    private void displayHelpMessage() {
        System.out.println("HRAssistant - COMP90041 - Final Project");
        System.out.println();
        System.out.println("Usage: java HRAssistant [arguments]");
        System.out.println();
        System.out.println("Arguments:");
        System.out.println("    -r or --role            Mandatory: determines the user's role");
        System.out.println("    -a or --applications    Optional: path to applications file");
        System.out.println("    -j or --jobs            Optional: path to jobs file");
        System.out.println("    -h or --help            Optional: print Help (this message) and exit");
        System.exit(0);
    }

    /**
     * Decide the menu messages to print accroding to user role.
     */
    public void displayMenuMessage() {

        if (this.role.equals("applicant")) {
            displayApplicationMenuMessage();
        } else if (this.role.equals("hr")) {
            displayHrMenuMessage();
        } else if (this.role.equals("audit")) {
            displayAuditMenuMessage();
        }
    }

    /**
     * Print menu messages of application system
     */
    private void displayApplicationMenuMessage() {
        System.out.println(
                this.getNumberAvailableJobs() + " jobs available. " + this.getNumberAppliedJobs()
                        + " applications submitted.");
        System.out.println("Please enter one of the following commands to continue:");
        if (this.newApplication == null) {
            System.out.println("- create new application: [create] or [c]");
        }
        System.out.println("- list available jobs: [jobs] or [j]");
        System.out.println("- quit the program: [quit] or [q]");

    }

    /**
     * Print menu messages of hr system
     */
    private void displayHrMenuMessage() {
        System.out.println(this.getNumberApplicants() + " applications received.");
        System.out.println("Please enter one of the following commands to continue:");
        System.out.println("- create new job: [create] or [c]");
        System.out.println("- list available jobs: [jobs] or [j]");
        System.out.println("- list applicants: [applicants] or [a]");
        System.out.println("- filter applications: [filter] or [f]");
        System.out.println("- matchmaking: [match] or [m]");
        System.out.println("- quit the program: [quit] or [q]");

    }

    /**
     * Print menu messages of audit system
     */
    private void displayAuditMenuMessage() {
        System.out.println("======================================");
        System.out.println("# Matchmaking Audit");
        System.out.println("======================================");

    }

    /**
     * Print error messages for invalid input of the target field.
     * 
     * @param field the target field
     */
    private void displayInvalidInputMessage(String field) {
        System.out.print("Invalid input! Please specify " + field + ": ");
    }

    /**
     * Print information of the target job.
     * 
     * @param job the target Job object
     * @see Job
     */
    private void displayJobs(Job job) {
        System.out.println(job.getTitle() + " (" + job.getDescription() + "). "
                + job.getDegree() + ". Salary: " + job.getSalary() + ". Start Date: " + job.getStartDate());
    }

    /**
     * Print information of the target appliction
     * 
     * @param application the target Application object
     * @see Application
     */
    public static void displayApplicant(Application application) {
        System.out.println(application.getLastname() + ", " + application.getFirstname()
                + " (" + application.getHighestDegree() + "): " + application.getCareerSummary()
                + ". Salary Expectations: " + application.getSalaryExpectations() + ": Available: "
                + application.getAvailability());
    }

    /**
     * Print the list number
     * 
     * @param listNum the list number to be print
     */
    public static void displayListNum(String listNum) {
        System.out.print("[" + listNum + "] ");
    }

}
