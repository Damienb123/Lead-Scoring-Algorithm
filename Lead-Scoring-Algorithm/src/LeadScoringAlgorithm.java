import java.util.HashMap;
import java.util.Map;
/*
 * Creation of the Lead Scoring Algorithm that assigns scores to leads
 * based on criteria like demographics, engagement level, and past behavior.
 * Rule-based approaches to predict lead quality are implemented. 
 * 
 * The algorithm can customized adjusting the attribute weights or
 * adding/removing attributes as needed based on your specific requirements
 * and data.
 * */
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
        
        // Calculate lead score
        int leadScore = calculateLeadScore(leadAttributes);
        System.out.println("Lead Score: " + leadScore);
    }
}
