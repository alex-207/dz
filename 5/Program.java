import models.Reservation;
import models.TableModel;
import presenters.BookingPresenter;
import views.BookingView;

import java.util.Date;
import java.io.IOException;

public class Program {

    public static void main(String[] args) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  // очистка консоли

         /** ДЗ 5
         * Метод changeReservationTable должен ЗАРАБОТАТЬ!
         */

        TableModel model = new TableModel();  // модель
        BookingView view = new BookingView();  // представление - интерфейс для бронирования столиков
        BookingPresenter bookingPresenter = new BookingPresenter(model, view);  // ядро - связующее звено для model и view (которые соблюдают контракты) воедино
        bookingPresenter.updateTablesUI();  // отобразить из presenter актуальную коллекцию всех доступных для резерва столиков

        view.reservationTable(new Date(), 3, "Станислав");

        view.changeReservationTable(101, new Date(), 5, "Станислав");
    }
}