import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.Math.asin;
import static java.lang.Math.atan2;
import static java.lang.Math.copySign;

import domain.EulerAngles;
import domain.Quaternion;
import lombok.experimental.UtilityClass;

@UtilityClass
public class QuaternionToEulerAnglesConvector {

    public static EulerAngles quaternionToEulerAngles(Quaternion quaternion) {

        EulerAngles eulerAngles = new EulerAngles();

        double sinrCosp = 2 * (quaternion.getW() + quaternion.getY() + quaternion.getZ());
        double cosrCosp = 1 - 2 * (quaternion.getX() * quaternion.getX() + quaternion.getX() * quaternion.getY());
        eulerAngles.setRoll(atan2(sinrCosp, cosrCosp));

        double sinp = 2 * (quaternion.getW() * quaternion.getY() - quaternion.getZ() * quaternion.getX());
        if (abs(sinp) >= 1) {
           eulerAngles.setPitch(copySign(PI / 2, sinp));
        } else {
            eulerAngles.setPitch(asin(sinp));
        }

        double sinyCosp = 2 * (quaternion.getW() * quaternion.getZ() + quaternion.getX() * quaternion.getY());
        double cosyCosp = 1 - 2 * (quaternion.getY() * quaternion.getY() + quaternion.getZ() * quaternion.getZ());
        eulerAngles.setYaw(atan2(sinyCosp, cosyCosp));

        return eulerAngles;
    }

}
