import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

class DateTimeWithOptional {
    private LocalDateTime currentDateTime;
    private DateTimeFormatter formatter;

    public DateTimeWithOptional() {
        this.currentDateTime = LocalDateTime.now();
        this.formatter = DateTimeFormatter.ofPattern("EEEE dd-MM-yyyy HH:mm:ss");
    }

    public void timeNow() {
        System.out.println("Current Time: " + currentDateTime.format(formatter));
    }

    public void afterHours(Optional<Integer> hours) {
        hours.ifPresentOrElse(
                h -> System.out.println("After " + h + " hours: "
                        + currentDateTime.plusHours(h).format(formatter)),
                () -> System.out.println("Cannot calculate time. No hours provided."));
    }

    public void afterDays(Optional<Integer> days) {
        days.ifPresentOrElse(
                p -> System.out.println("After " + p + " days: "
                        + currentDateTime.plusDays(p).format(formatter)),
                () -> System.out.println("Cannot calculate time. No days provided."));
    }

    public void afterWeeks(Optional<Integer> weeks) {
        weeks.ifPresentOrElse(
                w -> System.out.println("After " + w + " weeks: "
                        + currentDateTime.plusWeeks(w).format(formatter)),
                () -> System.out.println("Cannot calculate time. No weeks provided."));
    }

    public void afterMonths(Optional<Integer> months) {
        months.ifPresentOrElse(
                m -> System.out.println("After " + m + " months: "
                        + currentDateTime.plusMonths(m).format(formatter)),
                () -> System.out.println("Cannot calculate time. No months provided."));
    }

    public void afterYears(Optional<Integer> years) {
        years.ifPresentOrElse(
                y -> System.out.println("After " + years + " years: "
                        + currentDateTime.plusYears(y).format(formatter)),
                () -> System.out.println("Cannot calculate time. No years provided."));
    }

    public static void main(String[] args) {
        DateTimeWithOptional dt = new DateTimeWithOptional();

        dt.timeNow();
        dt.afterHours(Optional.empty());
        dt.afterDays(Optional.ofNullable(null));
        dt.afterWeeks(Optional.of(10));
        dt.afterMonths(Optional.of(1));
        dt.afterYears(Optional.of(5));
    }
}
