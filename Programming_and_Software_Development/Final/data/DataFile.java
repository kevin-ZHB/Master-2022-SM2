package data;
import java.util.*;
import java.io.*;
import java.util.regex.*;

import exception.InvalidCharacteristicException;
import exception.InvalidDataFormatException;
import exception.NumberFormatException;

/**
 * Abstract class DataFile is the base class for all file contexts.
 * 
 * @author Hongbo Zhou
 */
public abstract class DataFile {

    /**
     * Default folder that stores applicants for each job.
     */
    protected final static String DEFAULTJOBAPPLICATIONPATH = "./data/JobApplicant";
    /**
     * Number of fields of a jib.
     */
    protected final static int JOBNUMVALUES = 6;
    /**
     * Number of fields of a application.
     */
    protected final static int APPLICATIONNUMVALUES = 13;
    /**
     * Pattern of text within quotation marks.
     */
    protected final static String QUOTATIONPATTERN = "\"([^\"]*)\"";
    /**
     * Pattern of date.
     */
    protected final static String DATEPATTERN = "[0-9]{2}/[0-9]{2}/[0-9]{2}";
    /**
     * File header of application file.
     */
    protected final static String APPLICATIONFILEHEADER = "createdAt,lastname,firstname,careerSummary,age,gender,highestDegree,COMP90041,COMP90038,COMP90007,INFO90002,salayExpectations,availability";
    /**
     * File header of job file.
     */
    protected final static String JOBFILEHEADER = "createdAt,title,description,degree,salary,startDate";
    /**
     * List of supported degrees.
     */
    protected final static ArrayList<String> DEGREEVALUE = new ArrayList<>(Arrays.asList("Bachelor", "Master", "PHD"));
    /**
     * Number of data in the file.
     */
    protected int numCollection;
    /**
     * Number of field in the file.
     */
    protected int numValues;
    /**
     * Path of the file.
     */
    protected String path;
    /**
     * Type of the file, either "Application" or "Job".
     */
    protected String type;
    /**
     * User role of the system.
     */
    protected String role;

    /**
     * Constructor for invocation by subclass constructors.
     * 
     * @param path the path that the file is stored
     * @param type the type of data that are stored in the file, either
     *             "application" or "job"
     * @param role the user role of the system.
     */
    public DataFile(String path, String type, String role) {
        this.path = path;
        this.type = type;
        this.role = role;
        setNumValues();

    }

    /**
     * Empty parameter constructor for invocation by subclass constructors.
     */
    public DataFile() {

    }



    /**
     * Get total number of data in the file
     * @return total number of data
     */
    public int getNumCollection() {
        return numCollection;
    }

    /**
     * Set the number of fields in the file.
     */
    public void setNumValues() {
        if (this.type.equals("applications")) {
            this.numValues = APPLICATIONNUMVALUES;

        } else if (this.type.equals("jobs")) {
            this.numValues = JOBNUMVALUES;
        }
    }

    /**
     * Check if a int number is in the target list, typically for invocation by
     * subclasses.
     * 
     * @param list    the target list
     * @param element the int number to check
     * @return true if the element is in the list. Otherwise, false.
     */
    protected boolean contain(int[] list, int element) {
        for (int each : list) {
            if (each == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if the target string is an integer, typically for invocation by
     * subclasses.
     * 
     * @param str the target string to check.
     * @return true if the string is an integer. Otherwise, false.
     */
    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Check if the target string is double, typically for invocation by
     * subclasses.
     * 
     * @param str the target string to check.
     * @return true if the string is double. Otherwise, false.
     */
    protected boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Check whether the file is located at the specified location and create a new
     * file if none is found.
     * 
     * @param path the specified location.
     */
    protected void createFile(String path) {
        File file = new File(path);
        PrintWriter outputStream = null;
        try {
            file.createNewFile();
            outputStream = new PrintWriter(new FileOutputStream(path));
        } catch (IOException e2) {
            System.err.println(e2);
        }

        if (this.type.equals("applications")) {
            outputStream.println(APPLICATIONFILEHEADER);

        } else if (this.type.equals("jobs")) {
            outputStream.println(JOBFILEHEADER);
        }

        outputStream.close();
    }

    /**
     * Load data in the file
     */
    protected void loadFile() {
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream(this.path));
            int numLine = 0;
            while (inputStream.hasNextLine()) {
                if (numLine == 0) {
                    inputStream.nextLine();
                    numLine += 1;
                    continue;
                }

                createData(inputStream.nextLine(), numLine + 1);
                numLine += 1;
            }
            inputStream.close();

        } catch (FileNotFoundException e1) {
            createFile(this.path);
            this.numCollection = 0;
        }

    }

    /**
     * Format data in the file, typically for revmoing quotation marks, and split
     * into a
     * list.
     * 
     * @param text the String type data stored in csv file to be formatted.
     * @return a String list that contains all values of the data.
     */
    protected String[] cleanData(String text) {
        ArrayList<String> quotationTextArray = new ArrayList<>();

        Pattern p = Pattern.compile(QUOTATIONPATTERN);
        Matcher m = p.matcher(text);

        // Find quotation marks and temporarily store and replace the text within
        // quotation marks for counting number of values.
        while (m.find()) {
            String quoteText = m.group(1);
            quotationTextArray.add(quoteText);
            text = text.replaceAll(quoteText, "");
        }

        String[] values = text.split(",", this.numValues);

        if (quotationTextArray.size() != 0) {
            for (int i = 0; i < values.length; i++) {
                if (values[i].equals("\"\"")) {
                    values[i] = quotationTextArray.get(0);
                    quotationTextArray.remove(0);
                }
            }
        }
        return values;
    }

    /**
     * Check number format for each value in the list and display error messages.
     * 
     * @param values      the list of values to be checked
     * @param numLine     the list number of this list of values.
     * @param INTVALUE    the list that stored all positions that should be int
     *                    type.
     * @param DOUBLEVALUE the list that stored all positions that should be double
     *                    type.
     * @param STRINGVALUE the list that stored all positions that should be string
     *                    type.
     * @param MANDATORY   the list that stroed all positions that are mandatory.
     * @throws NumberFormatException customized exception for invalid number format.
     */
    protected void checkNumberFormat(String[] values, int numLine, int[] INTVALUE, int[] DOUBLEVALUE, int[] STRINGVALUE,
            int[] MANDATORY) throws NumberFormatException {
        boolean errorNonMandatory = false;
        for (int index = 0; index < this.numValues; index++) {
            if (values[index].equals("")) {
                continue;
            }

            // Check format and immediately terminate if the value is mandatory, else keep
            // checking.
            if ((contain(INTVALUE, index) && !isInteger(values[index]))
                    || (contain(DOUBLEVALUE, index) && !isDouble(values[index]))
                    || (contain(STRINGVALUE, index) && (isInteger(values[index]) || isDouble(values[index])))) {
                if (contain(MANDATORY, index)) {
                    throw new NumberFormatException();
                } else {
                    errorNonMandatory = true;
                }
            }

        }

        // If the value is invalid but not mandatory, display error messages and keep
        // running.
        if (errorNonMandatory) {
            try {
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                if (!this.role.equals("audit")) {
                    System.err.println("WARNING: invalid number format in " + this.type + " file in line " + numLine);

                }
            }
        }

    }

    /**
     * Print error message for invalid data format.
     * 
     * @param type    the type of this file, either "applications" or "jobs".
     * @param numLine the list number of the current data in the file.
     */
    protected void displayInvalidDataFormatMessage(String type, int numLine) {
        System.err.println("WARNING: invalid data format in " + this.type + " file in line " + numLine);

    }

    /**
     * Print error message for invalid number format.
     * 
     * @param type    the type of this file, either "applications" or "jobs".
     * @param numLine the list number of the current data in the file.
     */
    protected void displayInvalidNumberFormatMessage(String type, int numLine) {
        System.err.println("WARNING: invalid number format in " + this.type + " file in line " + numLine);

    }

    /**
     * Print error message for invalid characteristic.
     * 
     * @param type    the type of this file, either "applications" or "jobs".
     * @param numLine the list number of the current data in the file.
     */
    protected void displayInvalidCharacteristicMessage(String type, int numLine) {
        System.err.println("WARNING: invalid characteristic in " + this.type + " file in line " + numLine);

    }

    /**
     * Check if the format of date value is invalid.
     * 
     * @param value the data value to be checked.
     * @return true if the format is invalid. Otherwise, false.
     */
    public boolean isInvalidDateFormat(String value) {

        Pattern p = Pattern.compile(DATEPATTERN);
        Matcher m = p.matcher(value);
        boolean valid = m.matches();
        if (!valid) {
            return true;
        }

        return false;

    }

    /**
     * Check if the degree is invalid
     * 
     * @param value the input degree
     * @return true if the degree is invalid. Otherwise, false.
     */
    public boolean isInvalidHighestDegree(String value) {

        if (!DEGREEVALUE.contains(value)) {
            return true;
        }
        return false;
    }

    /**
     * Save the new data to the file by appending it to the end.
     * 
     * @param <T>  Class of the data to be saved, either "Application" or "Job".
     * @param data the new data to be save.
     * @see Application
     * @see Job
     */
    protected <T extends Data> void saveData(T data) {
        String values = String.join(",", joinString(data));
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileOutputStream(path, true));
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }

        outputStream.println(values);
        outputStream.close();
    }

    /**
     * Abstract method that should be implemented by subclass for joining values
     * into a string list.
     * 
     * @param <T>  Class of the data, either "Application" or "Job"
     * @param data the target data
     * @return the list of string that contains all values in data.
     */
    protected abstract <T extends Data> ArrayList<String> joinString(T data);

    /**
     * Abstract method that should be implemented by subclass for creating a new
     * data by reading one line of text.
     * 
     * @param text    the string type of data
     * @param numLine the list number of the data in the file.
     */
    protected abstract void createData(String text, int numLine);

    /**
     * Abstract method that should be implemented by subclass for checking data
     * format.
     * 
     * @param values the list of values to be checked
     * @throws InvalidDataFormatException customized exception for invalid data
     *                                    format.
     */
    protected abstract void checkDataFormat(String[] values) throws InvalidDataFormatException;

    /**
     * Abstract method that should be implemented by subclass for checking
     * characteristic.
     * 
     * @param values  the list of values to be checked
     * @param numLine the list number of the data in the file.
     * @throws InvalidCharacteristicException customized exception for invalid
     *                                        characteristic.
     */
    protected abstract void checkCharacteristic(String[] values, int numLine) throws InvalidCharacteristicException;

    /**
     * Abstract method that should be implemented by subclass for counting number of
     * data in the file.
     */
    protected abstract void countNumber();

}
