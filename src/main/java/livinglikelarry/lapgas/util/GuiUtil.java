package livinglikelarry.lapgas.util;

import org.controlsfx.dialog.ExceptionDialog;
import org.controlsfx.dialog.ProgressDialog;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * 
 * @author Moch Deden (https://github.com/selesdepselesnul)
 *
 */
public class GuiUtil {

	public static void showProgress(Runnable runnable) {
		Service<Void> service = new Service<Void>() {
			@Override
			protected Task<Void> createTask() {
				return new Task<Void>() {
					@Override
					protected Void call() throws InterruptedException {
						runnable.run();
						return null;
					}
				};
			}
		};

		ProgressDialog progressDialog = new ProgressDialog(service);
		progressDialog.setTitle("Mengambil data");
		progressDialog.setContentText("Melakukan pengambilan data");
		progressDialog.setHeaderText("Proses sedang berlangsung");
		progressDialog.setWidth(100);

		service.start();

	}

	public static void showReport(JasperPrint jasperPrint, String title) {
		JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
		jasperViewer.setTitle(title);
		jasperViewer.setVisible(true);
	}

	public static void showException(Throwable e) {
		ExceptionDialog exceptionDialog = new ExceptionDialog(e);
		exceptionDialog.setTitle("Kesalahan");
		exceptionDialog.setHeaderText("Telah terjadi kesalahan");
		exceptionDialog.showAndWait();
	}

	public static void alertPattern(String patternKind, String pattern) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Pola invalid");
		alert.setContentText("Pola " + patternKind + " yang dimasukan tidak cocok,\npola yang seharusnya " + pattern);
		alert.showAndWait();
	}

}
