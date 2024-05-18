# Lead-Scoring-Algorithm

## Table of Contents
1. [Overview](#Overview)
2. [Main Features](#Main-Features)
3. [Installation](#Installation)
4. [Usage](#Usage)
5. [Configuration](#Configuration)
6. [Code Structure](#Code-Structure)
    - LeadScoringAlgorithm.java
8. [Example Usage](#Example-Usage)
9. [Example Output](#Example-Output)
    - Detailed Breakdown

## Overview

The Lead Scoring Algorithm is a rule-based system that assigns scores to leads based on various criteria such as demographics, engagement level, and past behavior. This algorithm helps predict the quality of leads, making it easier for sales teams to prioritize and manage their leads effectively.
Main Features

## Installation

Clone the repository or download the source code files.
Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
Build and run the project.

## Usage

Define the lead attributes and their respective values.
Use the calculateLeadScore method to compute the lead score based on the defined attributes.
Adjust attribute weights in the ATTRIBUTE_WEIGHTS map as needed.

## Configuration

Attribute weights can be customized by modifying the ATTRIBUTE_WEIGHTS map in the LeadScoringAlgorithm class. Add or remove attributes by updating the leadAttributes map and the ATTRIBUTE_WEIGHTS map accordingly.

## Code Structure
LeadScoringAlgorithm.java

The main class implementing the lead scoring algorithm.

```
import java.util.HashMap;
import java.util.Map;

/*
 * Creation of the Lead Scoring Algorithm that assigns scores to leads
 * based on criteria like demographics, engagement level, and past behavior.
 * Rule-based approaches to predict lead quality are implemented. 
 * 
 * The algorithm can be customized by adjusting the attribute weights or
 * adding/removing attributes as needed based on your specific requirements
 * and data.
 */
public class LeadScoringAlgorithm {
    
    // Define weights for different lead attributes
    private static final Map<String, Integer> ATTRIBUTE_WEIGHTS = new HashMap<>();
    
    static {
        // weights can be adjusted as needed
        ATTRIBUTE_WEIGHTS.put("demographics", 5);
        ATTRIBUTE_WEIGHTS.put("engagementLevel", 3);
        ATTRIBUTE_WEIGHTS.put("pastBehavior", 4);
    }
    
    // Function to calculate lead score based on lead attributes
    public static int calculateLeadScore(Map<String, Integer> leadAttributes) {
        int leadScore = 0;
        
        // Iterate through lead attributes and calculate score
        for (Map.Entry<String, Integer> entry : leadAttributes.entrySet()) {
            String attribute = entry.getKey();
            int value = entry.getValue();
            
            if (ATTRIBUTE_WEIGHTS.containsKey(attribute)) {
                int weight = ATTRIBUTE_WEIGHTS.get(attribute);
                leadScore += weight * value;
            }
        }
        
        return leadScore;
    }
    
    public static void main(String[] args) {
        // Sample lead attributes
        Map<String, Integer> leadAttributes = new HashMap<>();
        leadAttributes.put("demographics", 8); // Higher value indicates better demographics
        leadAttributes.put("engagementLevel", 6); // Higher value indicates higher engagement level
        leadAttributes.put("pastBehavior", 7); // Higher value indicates positive past behavior

        /*
             leadAttributes.put("demographics", 4); // Lower value indicates poor demographics
             leadAttributes.put("engagementLevel", 2); // Lower value indicates decreased engagement level
             leadAttributes.put("pastBehavior", 2); // Lower value indicates negative past behavior
        */
        
        // Calculate lead score
        int leadScore = calculateLeadScore(leadAttributes);
        System.out.println("Lead Score: " + leadScore);
    }
}

```

## Example Usage
- Define the lead attributes with their respective values.
- Call the calculateLeadScore method to get the lead score.
- Adjust the weights in the ATTRIBUTE_WEIGHTS map to fine-tune the scoring criteria.

```
public static void main(String[] args) {
    // Sample lead attributes
    Map<String, Integer> leadAttributes = new HashMap<>();
    leadAttributes.put("demographics", 8); // Higher value indicates better demographics
    leadAttributes.put("engagementLevel", 6); // Higher value indicates higher engagement level
    leadAttributes.put("pastBehavior", 7); // Higher value indicates positive past behavior

    // Calculate lead score
    int leadScore = calculateLeadScore(leadAttributes);
    System.out.println("Lead Score: " + leadScore);
}

```

## Output Example
Running the main method with the sample lead attributes provided will produce the following output:

```
Lead Score: 86

```
### Detailed Breakdown

Given the weights and lead attributes used in the example:
- Weights:
  - demographics: 5
  - engagementLevel: 3
  - pastBehavior: 4
- Lead Attributes:
  - demographics: 8
  - engagementLevel: 6
  - pastBehavior: 7

The lead score calculation is performed as follows:
- demographics score contribution:
  - Weight: 5
  - Value: 8
  - Contribution: 5 * 8 = 40

engagementLevel score contribution:
  - Weight: 3
  - Value: 6
  - Contribution: 3 * 6 = 18

pastBehavior score contribution:
  - Weight: 4
  - Value: 7
  - Contribution: 4 * 7 = 28

Summing these contributions:
  - Total lead score = 40 (demographics) + 18 (engagementLevel) + 28 (pastBehavior) = 86

