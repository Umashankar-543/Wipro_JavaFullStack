import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/updateClaimStatus")
    @SendTo("/topic/claimStatus")
    public String handleClaimStatusUpdate(String message) {
        // Process the message and update claim status
        return "Claim status updated: " + message;
    }
}
