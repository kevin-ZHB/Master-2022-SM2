
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import data.Application;
import data.Job;

/**
 * Class Matchmaker is mainly for filtering applications and matching
 * applications to jobs, but also contains method for generating statistic for
 * audit system.
 */
public class Matchmaker {
    /**
     * List of valid gender
     */
    private final static String[] GENDER = { "male, femal" };

    /**
     * List of valid degree
     */
    private final static String[] DEGREE = { "Bachelor", "Master", "PHD" };

    /**
     * Total number of matched applicants.
     */
    private int numSuccessfulMatches = 0;

    /**
     * Average age of all matched applicants.
     */
    private double averageSuccessfulAge;

    /**
     * Average age of all applicants.
     */
    private double averageAllAge;

    /**
     * Average wam of all matched applicants.
     */
    private double averageSuccessfulWam;

    /**
     * Average wam of all applicants.
     */
    private double averageAllWam;

    /**
     * List of all jobs.
     */
    private ArrayList<Job> jobs;

    /**
     * List of all applications.
     */
    private ArrayList<Application> applications;

    /**
     * List of all un-matched applications.
     */
    private ArrayList<Application> unMatchedApplications = new ArrayList<>();

    /**
     * List of all mathced applications.
     */
    private ArrayList<Application> matchedApplicaitons = new ArrayList<>();

    /**
     * Map of gender distribution.
     */
    private Map<String, Double> genderOrder = new HashMap<>();

    /**
     * Map of degree distribution.
     */
    private Map<String, Double> degreeOrder = new HashMap<>();

    /**
     * Comparator for filtering by lastname.
     */
    private static Comparator<Application> lastnameComparator = new Comparator<Application>() {
        @Override
        public int compare(Application a1, Application a2) {
            return Matchmaker.lastnameCompare(a1.getLastname(), a2.getLastname());
        }
    };
    /**
     * Comparator for filtering by degree.
     */
    private static Comparator<Application> degreeComparator = new Comparator<Application>() {
        @Override
        public int compare(Application a1, Application a2) {
            return Matchmaker.degreeCompare(a1.getHighestDegree(), a2.getHighestDegree());
        }
    };
    /**
     * Comparator for filtering by wam.
     */
    private static Comparator<Application> wamComparator = new Comparator<Application>() {
        @Override
        public int compare(Application a1, Application a2) {
            return Matchmaker.wamCompare(a1.getWam(), a2.getWam());
        }
    };
    /**
     * Comparator for filtering by createAt.
     */
    private static Comparator<Application> createAtComparator = new Comparator<Application>() {
        @Override
        public int compare(Application a1, Application a2) {
            return Matchmaker.createAtCompare(a1.getCreateAt(), a2.getCreateAt());
        }
    };
    /**
     * Comparator for filtering by total name.
     */
    private static Comparator<Application> nameComparator = new Comparator<Application>() {
        @Override
        public int compare(Application a1, Application a2) {
            return (int) (a1.getName().compareTo(a2.getName()));
        }
    };

    /**
     * Class constructor specifying total jobs and total applications.
     * 
     * @param jobs         total jobs in job file
     * @param applications total applications in application file
     * @see Job
     * @see Application
     */
    public Matchmaker(ArrayList<Job> jobs, ArrayList<Application> applications) {
        this.jobs = jobs;
        this.applications = applications;

        // Match all applications to all jobs
        deepCopyApplications(unMatchedApplications, applications);
        Application topApplication;
        for (Job job : jobs) {
            topApplication = matchMaking(job, unMatchedApplications);
            if (topApplication != null) {
                this.numSuccessfulMatches += 1;
                this.matchedApplicaitons.add(topApplication);
                unMatchedApplications.remove(topApplication);
            }
        }
        this.numSuccessfulMatches = matchedApplicaitons.size();
        this.averageAllAge = calculateAverageAge(this.applications);
        this.averageSuccessfulAge = calculateAverageAge(this.matchedApplicaitons);
        this.averageAllWam = calculateAverageWam(applications);
        this.averageSuccessfulWam = calculateAverageAge(this.matchedApplicaitons);

    }

    /**
     * Get total number of matched applications
     * 
     * @return total number of matched applications
     */
    public int getNumSuccessfulMatches() {
        return numSuccessfulMatches;
    }

    /**
     * Set total number of matched applications
     * 
     * @param numSuccessfulMatches total number of matched applications
     */
    public void setNumSuccessfulMatches(int numSuccessfulMatches) {
        this.numSuccessfulMatches = numSuccessfulMatches;
    }

    /**
     * Get average age of all matched applicants.
     * 
     * @return average age of all matched applicants
     */
    public double getAverageSuccessfulAge() {
        return averageSuccessfulAge;
    }

    /**
     * Set average age of all matched applicants.
     * 
     * @param averageSuccessfulAge age of all matched applicants
     */
    public void setAverageSuccessfulAge(double averageSuccessfulAge) {
        this.averageSuccessfulAge = averageSuccessfulAge;
    }

    /**
     * Get average age of all applicants.
     * 
     * @return average age of all applicants
     */
    public double getAverageAllAge() {
        return averageAllAge;
    }

    /**
     * Set average age of all applicants.
     * 
     * @param averageAllAge average age of all applicants
     */
    public void setAverageAllAge(double averageAllAge) {
        this.averageAllAge = averageAllAge;
    }

    /**
     * Get average wam of all matched applicants.
     * 
     * @return average wam of all matched applicants
     */
    public double getAverageSuccessfulWam() {
        return averageSuccessfulWam;
    }

    /**
     * Set average wam of all matched applicants.
     * @param averageSuccessfulWam average wam of all matched applicants
     */
    public void setAverageSuccessfulWam(double averageSuccessfulWam) {
        this.averageSuccessfulWam = averageSuccessfulWam;
    }

    /**
     * Get average wam of all applicants.
     * @return average wam of all applicants
     */
    public double getAverageAllWam() {
        return averageAllWam;
    }

    /**
     * Set average wam of all applicants.
     * @param averageAllWam average wam of all applicants.
     */
    public void setAverageAllWam(double averageAllWam) {
        this.averageAllWam = averageAllWam;
    }

    /**
     * Get list of all jobs. 
     * @return list of all jobs
     */
    public ArrayList<Job> getJobs() {
        return jobs;
    }

    /**
     * Set list of all jobs.
     * @param jobs list of all jobs
     */
    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

    /**
     * Get list of all applications.
     * @return list of all applications
     */
    public ArrayList<Application> getApplications() {
        return applications;
    }
    
    /**
     * Set list of all applications.
     * @param applications list of all applications
     */
    public void setApplications(ArrayList<Application> applications) {
        this.applications = applications;
    }

    /**
     * Get list of all un-matched applications.
     * @return list of all un-matched applications
     */
    public ArrayList<Application> getUnMatchedApplications() {
        return unMatchedApplications;
    }

    /**
     * Set list of all un-matched applications.
     * @param unMatchedApplications list of all un-matched applications
     */
    public void setUnMatchedApplications(ArrayList<Application> unMatchedApplications) {
        this.unMatchedApplications = unMatchedApplications;
    }

    /**
     * Get list of all mathced applications.
     * @return list of all mathced applications
     */
    public ArrayList<Application> getMatchedApplicaitons() {
        return matchedApplicaitons;
    }

    /**
     * Set list of all mathced applications.
     * @param matchedApplicaitons list of all mathced applications
     */
    public void setMatchedApplicaitons(ArrayList<Application> matchedApplicaitons) {
        this.matchedApplicaitons = matchedApplicaitons;
    }

    /**
     * Deep copy a new application list.
     * 
     * @param newList the new application list
     * @param oldList the old application list to be copied
     */
    public static void deepCopyApplications(ArrayList<Application> newList, ArrayList<Application> oldList) {
        for (Application application : oldList) {
            newList.add(application.clone());
        }
    }

    /**
     * Calculate average age of given list of applications.
     * 
     * @param applications the target list of applications
     * @return average age of a double
     * @see Application
     */
    private double calculateAverageAge(ArrayList<Application> applications) {
        double totalAge = 0;
        double num = 0;
        for (Application application : applications) {
            if (!application.getAge().equals("n/a")) {
                totalAge += Double.parseDouble(application.getAge());
                num += 1;
            }
        }
        return num != 0 ? totalAge / num : 0;
    }

    /**
     * Calculate average wam of given list of applications.
     * 
     * @param applications the target list of aplications
     * @return average wam of a double
     * @see Application
     */
    private double calculateAverageWam(ArrayList<Application> applications) {
        double totalWam = 0;
        double num = 0;
        for (Application application : applications) {
            if (application.getWam() != 0) {
                totalWam += application.getWam();
                num += 1;
            }
        }
        return num != 0 ? totalWam / num : 0;
    }

    /**
     * Calculate distribution of all characteristic.
     */
    private void calculateDistribution() {

        double totalNum;
        double totalMatchedNum;
        for (String type : GENDER) {
            totalNum = counteNumber(applications, type, "gender");
            if (totalNum != 0) {
                totalMatchedNum = counteNumber(applications, type, "gender");
                Double distribution = Double.valueOf(totalMatchedNum / totalNum);
                genderOrder.put(type, distribution);
            }
        }
        for (String type : DEGREE) {
            totalNum = counteNumber(applications, type, "degree");
            if (totalNum != 0) {
                totalMatchedNum = counteNumber(matchedApplicaitons, type, "degree");
                Double distribution = Double.valueOf(totalMatchedNum / totalNum);
                degreeOrder.put(type, distribution);
            }
        }

    }

    /**
     * Counte total number of applications of a specified field.
     * 
     * @param applications total applications
     * @param type         the specified type of the field to check
     * @param field        the field to be checked
     * @return total number.
     * @see Application
     */
    private double counteNumber(ArrayList<Application> applications, String type, String field) {
        double totalNum = 0;
        switch (field) {
            case "gender":
                for (Application application : applications) {
                    if (application.getGender().equals(type)) {
                        totalNum += 1;
                    }
                }
                break;
            case "degree":
                for (Application application : applications) {
                    if (application.getHighestDegree().equals(type)) {
                        totalNum += 1;
                    }
                }
                break;
        }

        return totalNum;
    }

    /**
     * Filter applications by lastname.
     * 
     * @param applications the list of applications
     * @see Application
     */
    public static void lastnameFilter(ArrayList<Application> applications) {

        Collections.sort(applications, lastnameComparator);
        int lastnameListNum = 1;
        for (Application each : applications) {
            AssistantSystem.displayListNum(lastnameListNum + "");
            AssistantSystem.displayApplicant(each);
            lastnameListNum += 1;
        }
    }

    /**
     * Filter applications by degree
     * 
     * @param applications the list of applications
     * @see Application
     */
    public static void degreeFilter(ArrayList<Application> applications) {
        ArrayList<Application> noDegreeList = new ArrayList<>();
        ArrayList<Application> DegreeList = new ArrayList<>();
        for (Application each : applications) {
            if (each.getHighestDegree().equals("n/a")) {
                noDegreeList.add(each);
            } else {
                DegreeList.add(each);
            }
        }

        Collections.sort(DegreeList, degreeComparator);
        Collections.sort(noDegreeList, nameComparator);
        int degreeListNum = 1;
        for (Application each : DegreeList) {
            AssistantSystem.displayListNum(degreeListNum + "");
            AssistantSystem.displayApplicant(each);
            degreeListNum += 1;
        }

        for (Application each : noDegreeList) {
            AssistantSystem.displayListNum(degreeListNum + "");
            AssistantSystem.displayApplicant(each);
            degreeListNum += 1;
        }
    }

    /**
     * Filter applications by wam
     * 
     * @param applications the list of applications
     * @see Application
     */
    public static void wamFilter(ArrayList<Application> applications) {
        ArrayList<Application> noWamList = new ArrayList<>();
        ArrayList<Application> wamList = new ArrayList<>();
        for (Application each : applications) {
            if (each.getWam() > 0) {
                wamList.add(each);
            } else {
                noWamList.add(each);
            }
        }
        Collections.sort(wamList, wamComparator);
        Collections.sort(noWamList, nameComparator);
        int wamListNum = 1;
        for (Application each : wamList) {
            AssistantSystem.displayListNum(wamListNum + "");
            AssistantSystem.displayApplicant(each);
            wamListNum += 1;
        }

        for (Application each : noWamList) {
            AssistantSystem.displayListNum(wamListNum + "");
            AssistantSystem.displayApplicant(each);
            wamListNum += 1;
        }
    }

    /**
     * Filter applications by createAt
     * 
     * @param applications the lsit of applications
     * @see Application
     */
    public static void createAtFilter(ArrayList<Application> applications) {
        Collections.sort(applications, createAtComparator);
    }

    /**
     * Filter statistics of gender and degree ditribution separately in descending
     * order.
     * 
     * @param order Map of ditribution to be sorted
     * @return Sorted map
     */
    public Map<String, Double> orderFilter(Map<String, Double> order) {
        ArrayList<Map.Entry<String, Double>> list = new ArrayList<>(order.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> order1, Map.Entry<String, Double> order2) {
                return -order1.getValue().compareTo(order2.getValue());
            }
        });
        Map<String, Double> returnMap = new LinkedHashMap<>();
        for (Map.Entry<String, Double> entry : list) {
            returnMap.put(entry.getKey(), entry.getValue());
        }

        return returnMap;
    }

    /**
     * Compare lastname.
     * 
     * @param name1 the first lastname to compare
     * @param name2 the second lastnme to compare
     * @return -1 if name1 is "less than" name2; 0 if name1 is "equal to" name2; 1
     *         if name1 is "greater than" name2
     */
    private static int lastnameCompare(String name1, String name2) {
        return (int) (name1.compareTo(name2));
    }

    /**
     * Compare degree.
     * 
     * @param degree1 the first degree to compare
     * @param degree2 the second degree to compare
     * @return -1 if degree1 is "higher" than degree2; 0 if degree1 is "as the same
     *         as" degree2; 1 if degree1 is "lower" than degree2
     */
    private static int degreeCompare(String degree1, String degree2) {
        int result = 0;
        switch (degree1) {
            case "n/a":
                switch (degree2) {
                    case "n/a":
                        result = 0;
                        break;
                    default:
                        result = 1;
                }
                break;

            case "Bachelor":
                switch (degree2) {
                    case "n/a":
                        result = -1;
                        break;
                    case "Bachelor":
                        result = 0;
                    default:
                        result = 1;
                }

                break;

            case "Master":
                switch (degree2) {
                    case "n/a":
                    case "Bachelor":
                        result = -1;
                        break;
                    case "Master":
                        result = 0;
                    default:
                        result = 1;
                }

                break;

            case "PHD":
                switch (degree2) {
                    case "n/a":
                    case "Bachelor":
                    case "Master":
                        result = -1;
                        break;
                    default:
                        result = 0;
                }

                break;

        }
        return result;
    }

    /**
     * Compare wam
     * 
     * @param wam1 the first wam to compare
     * @param wam2 the second wam to compare
     * @return -1 if wam1 is "less than" wam2; 0 if wam1 is "equal to" wam 2; 1 if
     *         wam1 is "greater than" wam2
     */
    private static int wamCompare(double wam1, double wam2) {
        if (wam1 < wam2) {
            return 1;
        } else if (wam1 == wam2) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * Compare createAt
     * 
     * @param createAt1 the first createAt to compare
     * @param createAt2 the second createAt to compare
     * @return -1 if createAt1 is "before" createAt2; 0 if createAt1 is "as the same
     *         as" createAt2; 1 if
     *         createAt1 is "after" createAt2
     */
    private static int createAtCompare(String createAt1, String createAt2) {
        int a1Time = Integer.parseInt(createAt1);
        int a2Time = Integer.parseInt(createAt2);
        if (a1Time < a2Time) {
            return -1;
        } else if (a1Time == a2Time) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Check if the degree of the applicant is "higher" than the required degree of
     * the job
     * 
     * @param job         the job that the applicant applied
     * @param application the applicant
     * @return true if degree of the applicant is "higher" than the requirement.
     *         Otherwise, false.
     * @see Job
     * @see Application
     */
    public static boolean acceptableDegree(Job job, Application application) {
        return Matchmaker.degreeCompare(job.getDegree(), application.getHighestDegree()) >= 0;
    }

    /**
     * Check if the available date of the applicant is "after" the start date of the
     * job
     * 
     * @param job         the job that the applicant applied
     * @param application the applicant
     * @return true if the available date of the applicant is "after" the start
     *         date. Otherwise, false.
     * @see Job
     * @see Application
     */
    public static boolean acceptableDate(Job job, Application application) {
        String start = job.getStartDate();
        String availability = application.getAvailability();
        Date startDate;
        Date availabilityDate;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        formatter.setLenient(false);
        try {
            startDate = formatter.parse(start);
        } catch (ParseException e) {
            return true;
        }

        try {
            availabilityDate = formatter.parse(availability);
        } catch (ParseException e) {
            return false;
        }

        if (!startDate.before(availabilityDate)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check if the age the of the applicant is within 18 and 65.
     * 
     * @param application the applicant
     * @return true if the age the of the applicant is within 18 and 65. Otherwise,
     *         false.
     * @see Application
     */
    public static boolean acceptableAge(Application application) {
        int age = Integer.parseInt(application.getAge());
        if (age > 18 && age < 65) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Match applicants to the target job
     * 
     * @param job          the target job
     * @param applications all applicants that applied to this job
     * @return the top applicant if exists. Otherwise, null.
     * @see Application
     * @see Job
     */
    public static Application matchMaking(Job job, ArrayList<Application> applications) {
        if (applications.size() == 0) {
            return null;
        } else {
            Collections.sort(applications, degreeComparator);
            Application topApplicant = applications.get(0);
            if (acceptableDegree(job, topApplicant) && acceptableDate(job, topApplicant)
                    && acceptableAge(topApplicant)) {
                return topApplicant;
            } else {
                return null;
            }
        }

    }

    /**
     * Print statistic messages of audit system
     */
    public void displayAuditStatistic() {
        calculateDistribution();
        int numJobs = this.jobs.size();
        int numApplications = this.applications.size();
        if (numJobs == 0 && numApplications == 0) {
            System.out.println("No <jobs/applicants> available for interrogation.");
        } else if (numApplications == 0) {
            System.out.println("No applicants available for interrogation.");
        } else if (numJobs == 0) {
            System.out.println("No applicants jobs for interrogation.");
        } else {
            System.out.printf("Number of successful matches: %d%n", this.numSuccessfulMatches);
            System.out.printf("Average age: %.2f (average age of all applicants: %.2f)%n", this.averageSuccessfulAge,
                    this.averageAllAge);
            System.out.printf("Average WAM: %.2f (average WAM of all applicants: %.2f)%n", this.averageSuccessfulWam,
                    this.averageAllWam);
            displayGenderStatistic();
            displayDegreeStatistic();
        }

    }

    /**
     * Print statistic messages of gender if exists
     */
    private void displayGenderStatistic() {
        this.genderOrder = orderFilter(genderOrder);
        for (Map.Entry<String, Double> entry : genderOrder.entrySet()) {
            System.out.printf("%s: %.2f%n", entry.getKey(), entry.getValue());
        }

    }

    /**
     * Print statistic messages of degree if exists
     */
    private void displayDegreeStatistic() {
        this.degreeOrder = orderFilter(degreeOrder);
        for (Map.Entry<String, Double> entry : degreeOrder.entrySet()) {
            System.out.printf("%s: %.2f%n", entry.getKey(), entry.getValue());
        }
    }

}
