public class CircuitPath {
    private HardwareComponent hwComponent1;
    private HardwareComponent hwComponent2;

    public CircuitPath(HardwareComponent hwComponent1, HardwareComponent hwComponent2) {
        this.hwComponent1 = hwComponent1;
        this.hwComponent2 = hwComponent2;
    }

    public HardwareComponent getHwComponent1() {
        return hwComponent1;
    }

    public HardwareComponent getHwComponent2() {
        return hwComponent2;
    }
}
