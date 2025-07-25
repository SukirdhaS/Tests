import json
import xml.etree.ElementTree as ET
from datetime import datetime

# Load your JSON report
with open('report.json', 'r') as f:
    data = json.load(f)

# Root <testsuites> element
testsuites = ET.Element("testsuites")
testsuite = ET.SubElement(testsuites, "testsuite", {
    "name": data["name"],
    "tests": str(data["totalPass"] + data["totalFail"]),
    "failures": str(data["totalFail"]),
    "timestamp": data["timestamp"],
    "time": str(data["totalTime"] / 1000)  # Convert ms to seconds
})

# Add each test case
for result in data["results"]:
    testcase = ET.SubElement(testsuite, "testcase", {
        "classname": "ShopAPI",
        "name": result["name"],
        "time": str(result["time"] / 1000)  # in seconds
    })
    
    # If test has failures, include <failure> element
    if result["responseCode"]["code"] >= 400:
        failure = ET.SubElement(testcase, "failure", {
            "message": f"Failed with status code {result['responseCode']['code']}"
        })
        failure.text = json.dumps(result["tests"], indent=2)

# Save the XML file
tree = ET.ElementTree(testsuites)
tree.write("junit_report.xml", encoding="utf-8", xml_declaration=True)

print("JUnit report generated as 'junit_report.xml'")
