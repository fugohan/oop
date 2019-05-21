import managementserver.IManagementServer;
import managementserver.ManagementServer;
import warehouse.IWarehouse;
import warehouse.Warehouse;
import warehouse.ui.WarehouseManager;

public class RestaurantManagementSystem {

	public static void run() {

//		// Create ManagementServer and Warehouse
		IManagementServer mngServer = ManagementServer.GET_INSTANCE();
		IWarehouse warehouse = Warehouse.GET_INSTANCE();
		
		// TODO: register mngServer as listener at the warehouse

		// TODO: add Products to warehouse
		
		// TODO: create CashRegister and register it as an observer at the mngServer

		// TODO: Create GUI for CashRegister

		new WarehouseManager(warehouse);
		new ManagementServerViewer(ManagementServer.GET_INSTANCE());

		// TODO: register CashRegisterGUI as an UI at the previously created cashRegister

	}
}
