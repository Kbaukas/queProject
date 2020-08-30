package lt.kb.que.util;

public enum Speciality {
    ADMIN(20),ACCOUNTANT(15),MANAGER(10),SUPPORT(10);
    private final Integer sessionTime;

    Speciality(Integer sessionTime) {
        this.sessionTime = sessionTime;
    }

    public Integer getSessionTime() {
        return sessionTime;
    }
}
