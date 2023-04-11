package errorlogger;

public interface ErrorWritable
{
    void writeToErrorLog(Exception e);
}