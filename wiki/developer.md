# Developer userguide
### How to configure IDE to set Capella as TP
* Download IDE [Eclipse RCP 2024-03](https://www.eclipse.org/downloads/packages/release/2024-03/r/eclipse-ide-rcp-and-rap-developers)
* Download TP [Capella Studio 6.1](https://download.eclipse.org/capella/core/products/releases/6.1.0/)
* Open IDE (Eclipse RCP)
* Set Capella as Target Platform (by triggering `Capella_6.1/capella` as TP)
    * Open menu `Windows > Preferences > Plugin Development > Target Platform`
    * Click on `Add > Nothing / Next > Add / Directory` > choose the `capella` folder and click `Finish`.
    * Choose the newly created target then click on `Apply and Close` to close Preferences

### How to run Capella debug instance
* Open menu `Run > Run Configurations`
* Double Click on `Eclipse Application` to create a new Running Platform
* Then in `Program to Run`, choose `org.polarsys.capella.rcp.product`
