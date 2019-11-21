package org.datadog.jenkins.plugins.datadog;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import java.io.IOException;

public interface DatadogClient {

    public Integer OK = 0;
    public Integer WARNING = 1;
    public Integer CRITICAL = 2;
    public Integer UNKNOWN = 3;

    /**
     * Sends an event to the Datadog API, including the event payload.
     *
     * @param payload - The payload to send
     * @return a boolean to signify the success or failure of the HTTP POST request.
     */
    public boolean sendEvent(JSONObject payload);

    /**
     * Sends a metric to the Datadog API, including the gauge name, and value.
     *
     * @param name     - A String with the name of the metric to record.
     * @param value    - A long containing the value to submit.
     * @param hostname - A String with the hostname to submit.
     * @param tags     - A Object containing the tags to submit.
     * @return a boolean to signify the success or failure of the HTTP POST request.
     */
    public boolean gauge(String name, long value, String hostname, JSONArray tags);

    /**
     * Sends a service check to the Datadog API, including the check name, and status.
     *
     * @param name     - A String with the name of the service check to record.
     * @param code     - An int with the status code to record for this service check.
     * @param hostname - A String with the hostname to submit.
     * @param tags     - A Object containing the tags to submit.
     * @return a boolean to signify the success or failure of the HTTP POST request.
     */
    public boolean serviceCheck(String name, int code, String hostname, JSONArray tags);

    /**
     * Tests the apiKey is valid.
     *
     * @return a boolean to signify the success or failure of the HTTP GET request.
     * @throws IOException      if there is an input/output exception.
     * @throws ServletException if there is a servlet exception.
     */
    public boolean validate() throws IOException, ServletException;

    /**
     * Sends a service check to the Datadog API, including the check name, and status.
     *
     * @param payloadLogs     - A JSONObject with the logs payload
     * @return a boolean to signify the success or failure of the HTTP POST request.
     */
    public boolean sendLogs(JSONObject payloadLogs) throws IOException;
}
