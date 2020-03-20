import domain.EulerAngles;
import domain.Quaternion;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExampleApp {

    public static void main(String[] args) {

        //set quaternion data
        Quaternion quaternion = new Quaternion(1, 1, 1, 1);
        EulerAngles eulerAngles = QuaternionToEulerAnglesConvector.quaternionToEulerAngles(quaternion);

        log.info("Кватернион: {}", quaternion);
        log.info("Углы ейлера: {}", eulerAngles);

    }

}
