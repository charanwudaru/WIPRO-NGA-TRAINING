import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class datetime {
    private LocalDateTime currentDateTime;
    private DateTimeFormatter formatter;

    public datetime() {
        this.currentDateTime = LocalDateTime.now();
        this.formatter = DateTimeFormatter.ofPattern("EEEE dd-MM-yyyy HH:mm:ss");
    }

    public void timenow() {
        System.out.println(this.currentDateTime.format(this.formatter));
    }

    public void afterhours(int hours) {
        System.out.println(this.currentDateTime.plusHours(hours).format(this.formatter));
    }

    public void afterdays(int days) {
        System.out.println(this.currentDateTime.plusDays(days).format(this.formatter));
    }

    public void afterweeks(int weeks) {
        System.out.println(this.currentDateTime.plusWeeks(weeks).format(this.formatter));
    }
    public void afterweeks() {
        System.out.println("Cannot calculate time. No weeks provided.");
    }

    public void aftermonths(int months) {
        System.out.println(this.currentDateTime.plusMonths(months).format(this.formatter));

    }

    public void afteryears(int years) {
        System.out.println(this.currentDateTime.plusYears(years).format(this.formatter));

    }


    public static void main(String[] args) {
        datetime dt = new datetime();
        dt.timenow();
        dt.afterhours(5);
        dt.afterweeks();
        dt.afterdays(1);
        dt.afterweeks(1);
        dt.aftermonths(1);
        dt.afteryears(1);
    }

}