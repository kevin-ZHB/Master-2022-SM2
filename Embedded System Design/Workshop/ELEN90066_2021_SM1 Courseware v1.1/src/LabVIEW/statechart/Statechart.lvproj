<?xml version='1.0' encoding='UTF-8'?>
<Project Type="Project" LVVersion="17008000">
	<Item Name="My Computer" Type="My Computer">
		<Property Name="server.app.propertiesEnabled" Type="Bool">true</Property>
		<Property Name="server.control.propertiesEnabled" Type="Bool">true</Property>
		<Property Name="server.tcp.enabled" Type="Bool">false</Property>
		<Property Name="server.tcp.port" Type="Int">0</Property>
		<Property Name="server.tcp.serviceName" Type="Str">My Computer/VI Server</Property>
		<Property Name="server.tcp.serviceName.default" Type="Str">My Computer/VI Server</Property>
		<Property Name="server.vi.callsEnabled" Type="Bool">true</Property>
		<Property Name="server.vi.propertiesEnabled" Type="Bool">true</Property>
		<Property Name="specify.custom.address" Type="Bool">false</Property>
		<Item Name="CyberSim interface" Type="Folder" URL="../../CyberSim interface">
			<Property Name="NI.DISK" Type="Bool">true</Property>
		</Item>
		<Item Name="shared" Type="Folder" URL="../../shared">
			<Property Name="NI.DISK" Type="Bool">true</Property>
		</Item>
		<Item Name="DeployTest.vi" Type="VI" URL="../../system/DeployTest.vi"/>
		<Item Name="Simulation Statechart.vi" Type="VI" URL="../Simulation Statechart.vi"/>
		<Item Name="Statechart.lvsc" Type="LVStatechart" URL="../Statechart.lvsc"/>
		<Item Name="Dependencies" Type="Dependencies">
			<Item Name="vi.lib" Type="Folder">
				<Item Name="Application Directory.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/file.llb/Application Directory.vi"/>
				<Item Name="Check if File or Folder Exists.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/libraryn.llb/Check if File or Folder Exists.vi"/>
				<Item Name="Error Cluster From Error Code.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Error Cluster From Error Code.vi"/>
				<Item Name="NI_FileType.lvlib" Type="Library" URL="/&lt;vilib&gt;/Utility/lvfile.llb/NI_FileType.lvlib"/>
				<Item Name="NI_PackedLibraryUtility.lvlib" Type="Library" URL="/&lt;vilib&gt;/Utility/LVLibp/NI_PackedLibraryUtility.lvlib"/>
			</Item>
			<Item Name="feedbackMode.ctl" Type="VI" URL="../../CyberSim/autograder/feedbackMode.ctl"/>
			<Item Name="Kobuki Bumps and WheelDrops.ctl" Type="VI" URL="../../Kobuki/Kobuki Bumps and WheelDrops.ctl"/>
			<Item Name="Kobuki Buttons.ctl" Type="VI" URL="../../Kobuki/Kobuki Buttons.ctl"/>
			<Item Name="KobukiSensors.ctl" Type="VI" URL="../../Kobuki/KobukiSensors.ctl"/>
		</Item>
		<Item Name="Build Specifications" Type="Build"/>
	</Item>
	<Item Name="myRIO" Type="RT myRIO">
		<Property Name="alias.name" Type="Str">myRIO</Property>
		<Property Name="alias.value" Type="Str">172.22.11.2</Property>
		<Property Name="CCSymbols" Type="Str">OS,Linux;CPU,ARM;DeviceCode,762F;TARGET_TYPE,RT;</Property>
		<Property Name="crio.ControllerPID" Type="Str">762F</Property>
		<Property Name="crio.family" Type="Str">ARMLinux</Property>
		<Property Name="host.ResponsivenessCheckEnabled" Type="Bool">true</Property>
		<Property Name="host.ResponsivenessCheckPingDelay" Type="UInt">5000</Property>
		<Property Name="host.ResponsivenessCheckPingTimeout" Type="UInt">1000</Property>
		<Property Name="host.TargetCPUID" Type="UInt">8</Property>
		<Property Name="host.TargetOSID" Type="UInt">8</Property>
		<Property Name="mathScriptPath" Type="Str">\\psf\Home\Documents\LabVIEW Data</Property>
		<Property Name="target.cleanupVisa" Type="Bool">true</Property>
		<Property Name="target.FPProtocolGlobals_ControlTimeLimit" Type="Int">300</Property>
		<Property Name="target.getDefault-&gt;WebServer.Port" Type="Int">80</Property>
		<Property Name="target.getDefault-&gt;WebServer.Timeout" Type="Int">60</Property>
		<Property Name="target.IOScan.Faults" Type="Str">1.0,0;</Property>
		<Property Name="target.IOScan.NetVarPeriod" Type="UInt">100</Property>
		<Property Name="target.IOScan.NetWatchdogEnabled" Type="Bool">false</Property>
		<Property Name="target.IOScan.Period" Type="UInt">10000</Property>
		<Property Name="target.IOScan.PowerupMode" Type="UInt">0</Property>
		<Property Name="target.IOScan.Priority" Type="UInt">0</Property>
		<Property Name="target.IOScan.ReportModeConflict" Type="Bool">true</Property>
		<Property Name="target.IOScan.StartEngineOnDeploy" Type="Bool">false</Property>
		<Property Name="target.IsRemotePanelSupported" Type="Bool">true</Property>
		<Property Name="target.RTCPULoadMonitoringEnabled" Type="Bool">true</Property>
		<Property Name="target.RTDebugWebServerHTTPPort" Type="UInt">8001</Property>
		<Property Name="target.RTTarget.ApplicationPath" Type="Path">/c/ni-rt/startup/startup.rtexe</Property>
		<Property Name="target.RTTarget.EnableFileSharing" Type="Bool">true</Property>
		<Property Name="target.RTTarget.IPAccess" Type="Str">+*</Property>
		<Property Name="target.RTTarget.LaunchAppAtBoot" Type="Bool">false</Property>
		<Property Name="target.RTTarget.VIPath" Type="Path">/home/lvuser/natinst/bin</Property>
		<Property Name="target.server.app.propertiesEnabled" Type="Bool">true</Property>
		<Property Name="target.server.control.propertiesEnabled" Type="Bool">true</Property>
		<Property Name="target.server.tcp.access" Type="Str">+*</Property>
		<Property Name="target.server.tcp.enabled" Type="Bool">true</Property>
		<Property Name="target.server.tcp.paranoid" Type="Bool">true</Property>
		<Property Name="target.server.tcp.port" Type="Int">3363</Property>
		<Property Name="target.server.tcp.serviceName" Type="Str"></Property>
		<Property Name="target.server.tcp.serviceName.default" Type="Str">Main Application Instance/VI Server</Property>
		<Property Name="target.server.vi.access" Type="Str">+*</Property>
		<Property Name="target.server.vi.callsEnabled" Type="Bool">true</Property>
		<Property Name="target.server.vi.propertiesEnabled" Type="Bool">true</Property>
		<Property Name="target.server.viscripting.showScriptingOperationsInContextHelp" Type="Bool">true</Property>
		<Property Name="target.server.viscripting.showScriptingOperationsInEditor" Type="Bool">true</Property>
		<Property Name="target.WebServer.Config" Type="Str"># Web server configuration file.
# Generated by LabVIEW 13.0f2
# 2014-03-29 16:38:42

#
# Global Directives
#
NI.AddLVRouteVars
TypesConfig "$LVSERVER_CONFIGROOT/mime.types"
LimitWorkers 10
LoadModulePath "$LVSERVER_MODULEPATHS"
LoadModule LVAuth lvauthmodule
LoadModule LVRFP lvrfpmodule
Listen 8000

#
# Directives that apply to the default server
#
NI.ServerName LabVIEW
DocumentRoot "$LVSERVER_DOCROOT"
InactivityTimeout 60
SetConnector netConnector
AddHandler LVAuth
AddHandler LVRFP
AddHandler fileHandler ""
AddOutputFilter chunkFilter
DirectoryIndex index.htm
</Property>
		<Property Name="target.WebServer.Enabled" Type="Bool">false</Property>
		<Property Name="target.WebServer.LogEnabled" Type="Bool">false</Property>
		<Property Name="target.WebServer.LogPath" Type="Path">/c/ni-rt/system/www/www.log</Property>
		<Property Name="target.WebServer.Port" Type="Int">80</Property>
		<Property Name="target.WebServer.RootPath" Type="Path">/c/ni-rt/system/www</Property>
		<Property Name="target.WebServer.TcpAccess" Type="Str">c+*</Property>
		<Property Name="target.WebServer.Timeout" Type="Int">60</Property>
		<Property Name="target.WebServer.ViAccess" Type="Str">+*</Property>
		<Property Name="target.webservices.SecurityAPIKey" Type="Str">PqVr/ifkAQh+lVrdPIykXlFvg12GhhQFR8H9cUhphgg=:pTe9HRlQuMfJxAG6QCGq7UvoUpJzAzWGKy5SbZ+roSU=</Property>
		<Property Name="target.webservices.ValidTimestampWindow" Type="Int">15</Property>
		<Item Name="Kobuki" Type="Folder" URL="../../Kobuki">
			<Property Name="NI.DISK" Type="Bool">true</Property>
		</Item>
		<Item Name="shared" Type="Folder" URL="../../shared">
			<Property Name="NI.DISK" Type="Bool">true</Property>
		</Item>
		<Item Name="Chassis" Type="myRIO Chassis">
			<Property Name="crio.ProgrammingMode" Type="Str">fpga</Property>
			<Property Name="crio.ResourceID" Type="Str">RIO0</Property>
			<Property Name="crio.Type" Type="Str">myRIO-1900</Property>
			<Property Name="NI.SortType" Type="Int">3</Property>
			<Item Name="Real-Time Scan Resources" Type="Module Container">
				<Property Name="crio.ModuleContainerType" Type="Str">crio.RSIModuleContainer</Property>
			</Item>
		</Item>
		<Item Name="Robot Drive Direct.vi" Type="VI" URL="../../system/Robot Drive Direct.vi"/>
		<Item Name="Statechart.lvsc" Type="LVStatechart" URL="../Statechart.lvsc"/>
		<Item Name="Target.vi" Type="VI" URL="../Target.vi"/>
		<Item Name="Dependencies" Type="Dependencies">
			<Item Name="instr.lib" Type="Folder">
				<Item Name="DC Motor Controller.lvclass" Type="LVClass" URL="/&lt;instrlib&gt;/DC Motor Controller/HAIOL/DC Motor Controller.lvclass"/>
			</Item>
			<Item Name="vi.lib" Type="Folder">
				<Item Name="Accelerometer Channels Enum.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/Accelerometer/typedefs/Accelerometer Channels Enum.ctl"/>
				<Item Name="Accelerometer Channels List.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/Accelerometer/typedefs/Accelerometer Channels List.ctl"/>
				<Item Name="Accelerometer FPGA Reference.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/Accelerometer/typedefs/Accelerometer FPGA Reference.ctl"/>
				<Item Name="Accelerometer.lvlib" Type="Library" URL="/&lt;vilib&gt;/myRIO/Instrument Drivers/Onboard Devices/Accelerometer/Accelerometer.lvlib"/>
				<Item Name="AI IRQ FPGA Reference.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/IRQ/typedefs/AI IRQ FPGA Reference.ctl"/>
				<Item Name="Application Directory.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/file.llb/Application Directory.vi"/>
				<Item Name="BuildHelpPath.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/BuildHelpPath.vi"/>
				<Item Name="Callback VI Ref.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/IRQ/typedefs/Callback VI Ref.ctl"/>
				<Item Name="CANCloseInterface.vi" Type="VI" URL="/&lt;vilib&gt;/RioEmbeddedCAN/RioEmbeddedCAN.llb/CANCloseInterface.vi"/>
				<Item Name="CANStatusToError.vi" Type="VI" URL="/&lt;vilib&gt;/RioEmbeddedCAN/RioEmbeddedCAN.llb/CANStatusToError.vi"/>
				<Item Name="CANStop.vi" Type="VI" URL="/&lt;vilib&gt;/RioEmbeddedCAN/RioEmbeddedCAN.llb/CANStop.vi"/>
				<Item Name="Check if File or Folder Exists.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/libraryn.llb/Check if File or Folder Exists.vi"/>
				<Item Name="Check Special Tags.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Check Special Tags.vi"/>
				<Item Name="Clear Errors.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Clear Errors.vi"/>
				<Item Name="Configuration Manager.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/vis/Configuration Manager.vi"/>
				<Item Name="Convert property node font to graphics font.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Convert property node font to graphics font.vi"/>
				<Item Name="Details Display Dialog.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Details Display Dialog.vi"/>
				<Item Name="DI IRQ FPGA Reference.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/IRQ/typedefs/DI IRQ FPGA Reference.ctl"/>
				<Item Name="DialogType.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/DialogType.ctl"/>
				<Item Name="DialogTypeEnum.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/DialogTypeEnum.ctl"/>
				<Item Name="EL-RIO-CM v1.0 FPGA.lvbitx" Type="Document" URL="/&lt;vilib&gt;/myRIO/FPGA/bitfiles/EL-RIO-CM v1.0 FPGA.lvbitx"/>
				<Item Name="EL-RIO-CM v1.0 Open.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/EL-RIO-CM v1.0/EL-RIO-CM v1.0 Open.vi"/>
				<Item Name="Error Cluster From Error Code.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Error Cluster From Error Code.vi"/>
				<Item Name="Error Code Database.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Error Code Database.vi"/>
				<Item Name="ErrWarn.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/ErrWarn.ctl"/>
				<Item Name="eventvkey.ctl" Type="VI" URL="/&lt;vilib&gt;/event_ctls.llb/eventvkey.ctl"/>
				<Item Name="Find Mutex.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/vis/Find Mutex.vi"/>
				<Item Name="Find Tag.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Find Tag.vi"/>
				<Item Name="Format Message String.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Format Message String.vi"/>
				<Item Name="FPGA Ref Manager Action Enum.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/typedefs/FPGA Ref Manager Action Enum.ctl"/>
				<Item Name="FPGA Ref Manager.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/vis/FPGA Ref Manager.vi"/>
				<Item Name="General Error Handler Core CORE.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/General Error Handler Core CORE.vi"/>
				<Item Name="General Error Handler.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/General Error Handler.vi"/>
				<Item Name="Generic FPGA Reference.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/typedefs/Generic FPGA Reference.ctl"/>
				<Item Name="Generic IRQ Array.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/IRQ/typedefs/Generic IRQ Array.ctl"/>
				<Item Name="Generic IRQ.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/IRQ/typedefs/Generic IRQ.ctl"/>
				<Item Name="Get String Text Bounds.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Get String Text Bounds.vi"/>
				<Item Name="Get Text Rect.vi" Type="VI" URL="/&lt;vilib&gt;/picture/picture.llb/Get Text Rect.vi"/>
				<Item Name="GetHelpDir.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/GetHelpDir.vi"/>
				<Item Name="GetRTHostConnectedProp.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/GetRTHostConnectedProp.vi"/>
				<Item Name="Hardware Version Enum.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/typedefs/Hardware Version Enum.ctl"/>
				<Item Name="IO IRQ Channels Enum.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/IRQ/typedefs/IO IRQ Channels Enum.ctl"/>
				<Item Name="IO Manager.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/vis/IO Manager.vi"/>
				<Item Name="IRQ Type.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/IRQ/typedefs/IRQ Type.ctl"/>
				<Item Name="Is FPGA Ref Available.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/vis/Is FPGA Ref Available.vi"/>
				<Item Name="Lock Mutex.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/vis/Lock Mutex.vi"/>
				<Item Name="Longest Line Length in Pixels.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Longest Line Length in Pixels.vi"/>
				<Item Name="LVBoundsTypeDef.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/miscctls.llb/LVBoundsTypeDef.ctl"/>
				<Item Name="LVNumericRepresentation.ctl" Type="VI" URL="/&lt;vilib&gt;/numeric/LVNumericRepresentation.ctl"/>
				<Item Name="LVRectTypeDef.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/miscctls.llb/LVRectTypeDef.ctl"/>
				<Item Name="Mutex Collection.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/typedefs/Mutex Collection.ctl"/>
				<Item Name="myRIO Generic Hardware Reference.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/typedefs/myRIO Generic Hardware Reference.ctl"/>
				<Item Name="myRIO v1.0 Build Mutex Name.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/Resource Manager/vis/myRIO v1.0 Build Mutex Name.vi"/>
				<Item Name="myRIO v1.0 Build MUX Configuration Accelerometer.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/Accelerometer/vis/myRIO v1.0 Build MUX Configuration Accelerometer.vi"/>
				<Item Name="myRIO v1.0 Channel Reservation Info.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/Resource Manager/typedefs/myRIO v1.0 Channel Reservation Info.ctl"/>
				<Item Name="myRIO v1.0 Channel Reservation List.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/Resource Manager/typedefs/myRIO v1.0 Channel Reservation List.ctl"/>
				<Item Name="myRIO v1.0 Clear All IRQ.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/IRQ/vis/myRIO v1.0 Clear All IRQ.vi"/>
				<Item Name="myRIO v1.0 Close UART.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/UART/vis/myRIO v1.0 Close UART.vi"/>
				<Item Name="myRIO v1.0 Close.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/myRIO v1.0 Close.vi"/>
				<Item Name="myRIO v1.0 Connector List.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/Resource Manager/typedefs/myRIO v1.0 Connector List.ctl"/>
				<Item Name="myRIO v1.0 Get Scaling Constant Accelerometer.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/Accelerometer/vis/myRIO v1.0 Get Scaling Constant Accelerometer.vi"/>
				<Item Name="myRIO v1.0 Get Scaling Constants.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/Resource Manager/vis/myRIO v1.0 Get Scaling Constants.vi"/>
				<Item Name="myRIO v1.0 IRQ Info FGV.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/IRQ/vis/myRIO v1.0 IRQ Info FGV.vi"/>
				<Item Name="myRIO v1.0 ISR Agent.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/IRQ/vis/myRIO v1.0 ISR Agent.vi"/>
				<Item Name="myRIO v1.0 ISR Worker.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/IRQ/vis/myRIO v1.0 ISR Worker.vi"/>
				<Item Name="myRIO v1.0 Read Accelerometer.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/Accelerometer/vis/myRIO v1.0 Read Accelerometer.vi"/>
				<Item Name="myRIO v1.0 Reference.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/typedefs/myRIO v1.0 Reference.ctl"/>
				<Item Name="myRIO v1.0 Reserve Accelerometer.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/Accelerometer/vis/myRIO v1.0 Reserve Accelerometer.vi"/>
				<Item Name="myRIO v1.0 Reserve Channel List.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/Resource Manager/vis/myRIO v1.0 Reserve Channel List.vi"/>
				<Item Name="myRIO v1.0 Reserve Channel.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/Resource Manager/vis/myRIO v1.0 Reserve Channel.vi"/>
				<Item Name="myRIO v1.0 Reset FPGA.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/myRIO v1.0 Reset FPGA.vi"/>
				<Item Name="myRIO v1.0 Scaling Constants Table.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/Resource Manager/vis/myRIO v1.0 Scaling Constants Table.vi"/>
				<Item Name="myRIO v1.0 Timer IRQ Info FGV.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/IRQ/vis/myRIO v1.0 Timer IRQ Info FGV.vi"/>
				<Item Name="myRIO v1.0 Unreserve Channel.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/Resource Manager/vis/myRIO v1.0 Unreserve Channel.vi"/>
				<Item Name="myRIO v1.0 Wait for RDY.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/System/vis/myRIO v1.0 Wait for RDY.vi"/>
				<Item Name="myRIO v1.1 Accelerometer Channels Enum.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/Accelerometer/typedefs/myRIO v1.1 Accelerometer Channels Enum.ctl"/>
				<Item Name="myRIO v1.1 FPGA.lvbitx" Type="Document" URL="/&lt;vilib&gt;/myRIO/FPGA/bitfiles/myRIO v1.1 FPGA.lvbitx"/>
				<Item Name="myRIO v1.1 Open Accelerometer.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/Accelerometer/vis/myRIO v1.1 Open Accelerometer.vi"/>
				<Item Name="myRIO v1.1 Open.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/myRIO v1.1 Open.vi"/>
				<Item Name="myRIO v1.2 FPGA.lvbitx" Type="Document" URL="/&lt;vilib&gt;/myRIO/FPGA/bitfiles/myRIO v1.2 FPGA.lvbitx"/>
				<Item Name="myRIO v1.2 Open.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/myRIO v1.2 Open.vi"/>
				<Item Name="Named Mutex.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/typedefs/Named Mutex.ctl"/>
				<Item Name="NI_FileType.lvlib" Type="Library" URL="/&lt;vilib&gt;/Utility/lvfile.llb/NI_FileType.lvlib"/>
				<Item Name="NI_PackedLibraryUtility.lvlib" Type="Library" URL="/&lt;vilib&gt;/Utility/LVLibp/NI_PackedLibraryUtility.lvlib"/>
				<Item Name="Not Found Dialog.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Not Found Dialog.vi"/>
				<Item Name="Parse Scaling Constant Table.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/vis/Parse Scaling Constant Table.vi"/>
				<Item Name="Reentrant Mutex.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/typedefs/Reentrant Mutex.ctl"/>
				<Item Name="Ref Counter Action Enum.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/typedefs/Ref Counter Action Enum.ctl"/>
				<Item Name="Ref Counter.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/vis/Ref Counter.vi"/>
				<Item Name="Resource Manager Action Enum.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/typedefs/Resource Manager Action Enum.ctl"/>
				<Item Name="roboRIO Accelerometer FPGA Reference.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/roboRIO v1.0/Accelerometer/typedefs/roboRIO Accelerometer FPGA Reference.ctl"/>
				<Item Name="roboRIO AI IRQ FPGA Reference.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/roboRIO v1.0/IRQ/typedefs/roboRIO AI IRQ FPGA Reference.ctl"/>
				<Item Name="roboRIO DI IRQ FPGA Reference.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/roboRIO v1.0/IRQ/typedefs/roboRIO DI IRQ FPGA Reference.ctl"/>
				<Item Name="roboRIO v1.0 CAN Interface Manager.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/roboRIO v1.0/CAN/vis/roboRIO v1.0 CAN Interface Manager.vi"/>
				<Item Name="roboRIO v1.0 Clear All IRQ.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/roboRIO v1.0/IRQ/vis/roboRIO v1.0 Clear All IRQ.vi"/>
				<Item Name="roboRIO v1.0 FPGA.lvbitx" Type="Document" URL="/&lt;vilib&gt;/myRIO/FPGA/bitfiles/roboRIO v1.0 FPGA.lvbitx"/>
				<Item Name="roboRIO v1.0 ISR Agent.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/roboRIO v1.0/IRQ/vis/roboRIO v1.0 ISR Agent.vi"/>
				<Item Name="roboRIO v1.0 Open.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/roboRIO v1.0/roboRIO v1.0 Open.vi"/>
				<Item Name="roboRIO v1.0 Read Accelerometer.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/roboRIO v1.0/Accelerometer/vis/roboRIO v1.0 Read Accelerometer.vi"/>
				<Item Name="Search and Replace Pattern.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Search and Replace Pattern.vi"/>
				<Item Name="Set Bold Text.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Set Bold Text.vi"/>
				<Item Name="Set String Value.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Set String Value.vi"/>
				<Item Name="Set_Get Target Info.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/vis/Set_Get Target Info.vi"/>
				<Item Name="Simple Error Handler.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Simple Error Handler.vi"/>
				<Item Name="System FPGA Reference.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/System/typedefs/System FPGA Reference.ctl"/>
				<Item Name="TagReturnType.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/TagReturnType.ctl"/>
				<Item Name="Three Button Dialog CORE.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Three Button Dialog CORE.vi"/>
				<Item Name="Three Button Dialog.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Three Button Dialog.vi"/>
				<Item Name="Timer IRQ Array.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/IRQ/typedefs/Timer IRQ Array.ctl"/>
				<Item Name="Timer IRQ FPGA Reference.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/IRQ/typedefs/Timer IRQ FPGA Reference.ctl"/>
				<Item Name="Timer IRQ.ctl" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/myRIO v1.0/IRQ/typedefs/Timer IRQ.ctl"/>
				<Item Name="Trim Whitespace.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Trim Whitespace.vi"/>
				<Item Name="UART.lvlib" Type="Library" URL="/&lt;vilib&gt;/myRIO/Instrument Drivers/Onboard IO/UART/UART.lvlib"/>
				<Item Name="Unlock Mutex.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/vis/Unlock Mutex.vi"/>
				<Item Name="Utilities.lvlib" Type="Library" URL="/&lt;vilib&gt;/myRIO/Instrument Drivers/Utilities/Utilities.lvlib"/>
				<Item Name="Validate Channels.vi" Type="VI" URL="/&lt;vilib&gt;/myRIO/common/Instrument Driver Framework/Utilities/vis/Validate Channels.vi"/>
				<Item Name="VariantType.lvlib" Type="Library" URL="/&lt;vilib&gt;/Utility/VariantDataType/VariantType.lvlib"/>
				<Item Name="VISA Configure Serial Port" Type="VI" URL="/&lt;vilib&gt;/Instr/_visa.llb/VISA Configure Serial Port"/>
				<Item Name="VISA Configure Serial Port (Instr).vi" Type="VI" URL="/&lt;vilib&gt;/Instr/_visa.llb/VISA Configure Serial Port (Instr).vi"/>
				<Item Name="VISA Configure Serial Port (Serial Instr).vi" Type="VI" URL="/&lt;vilib&gt;/Instr/_visa.llb/VISA Configure Serial Port (Serial Instr).vi"/>
				<Item Name="VISA Flush IO Buffer Mask.ctl" Type="VI" URL="/&lt;vilib&gt;/Instr/_visa.llb/VISA Flush IO Buffer Mask.ctl"/>
				<Item Name="whitespace.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/whitespace.ctl"/>
			</Item>
			<Item Name="AccumulatingDifferences.vi" Type="VI" URL="../../system/AccumulatingDifferences.vi"/>
			<Item Name="feedbackMode.ctl" Type="VI" URL="../../CyberSim/autograder/feedbackMode.ctl"/>
			<Item Name="KobukiOdometers.vi" Type="VI" URL="../../system/KobukiOdometers.vi"/>
			<Item Name="NiFpgaLv.dll" Type="Document" URL="NiFpgaLv.dll">
				<Property Name="NI.PreserveRelativePath" Type="Bool">true</Property>
			</Item>
			<Item Name="Poll Robot and Accelerometer.vi" Type="VI" URL="../../system/Poll Robot and Accelerometer.vi"/>
			<Item Name="rioembeddedcanlvapi.dll" Type="Document" URL="rioembeddedcanlvapi.dll">
				<Property Name="NI.PreserveRelativePath" Type="Bool">true</Property>
			</Item>
			<Item Name="RobotData.ctl" Type="VI" URL="../../CyberSim/Multi Bot Code/RobotData.ctl"/>
			<Item Name="RobotOpen.vi" Type="VI" URL="../../system/RobotOpen.vi"/>
			<Item Name="RobotType.ctl" Type="VI" URL="../../system/RobotType.ctl"/>
			<Item Name="Simulation Configuration.ctl" Type="VI" URL="../../CyberSim interface/Simulation Configuration.ctl"/>
			<Item Name="Simulator.ctl" Type="VI" URL="../../CyberSim/simulation/Simulator.ctl"/>
		</Item>
		<Item Name="Build Specifications" Type="Build">
			<Item Name="My Source Distribution" Type="Source Distribution">
				<Property Name="Bld_autoIncrement" Type="Bool">true</Property>
				<Property Name="Bld_buildCacheID" Type="Str">{63FEF5B5-4F56-4A3D-88D3-6BC2B4040775}</Property>
				<Property Name="Bld_buildSpecName" Type="Str">My Source Distribution</Property>
				<Property Name="Bld_localDestDir" Type="Path">../builds/NI_AB_PROJECTNAME/NI_AB_TARGETNAME/My Source Distribution</Property>
				<Property Name="Bld_localDestDirType" Type="Str">relativeToCommon</Property>
				<Property Name="Bld_previewCacheID" Type="Str">{9543634D-A845-46F0-B30C-28246DE1D945}</Property>
				<Property Name="Bld_targetDestDir" Type="Path">/home/lvuser/natinst/bin</Property>
				<Property Name="Bld_version.build" Type="Int">6</Property>
				<Property Name="Bld_version.major" Type="Int">1</Property>
				<Property Name="Destination[0].destName" Type="Str">Destination Directory</Property>
				<Property Name="Destination[0].path" Type="Path">/home/lvuser/natinst/bin</Property>
				<Property Name="Destination[0].path.type" Type="Str">&lt;none&gt;</Property>
				<Property Name="Destination[1].destName" Type="Str">Support Directory</Property>
				<Property Name="Destination[1].path" Type="Path">/home/lvuser/natinst/bin/data</Property>
				<Property Name="Destination[1].path.type" Type="Str">&lt;none&gt;</Property>
				<Property Name="DestinationCount" Type="Int">2</Property>
				<Property Name="Source[0].itemID" Type="Str">{DD676DA2-72F8-4E98-9F20-8F4246272ED6}</Property>
				<Property Name="Source[0].type" Type="Str">Container</Property>
				<Property Name="Source[1].destinationIndex" Type="Int">0</Property>
				<Property Name="Source[1].itemID" Type="Ref">/myRIO/Target.vi</Property>
				<Property Name="Source[1].properties[0].type" Type="Str">Remove front panel</Property>
				<Property Name="Source[1].properties[0].value" Type="Bool">true</Property>
				<Property Name="Source[1].properties[1].type" Type="Str">Remove block diagram</Property>
				<Property Name="Source[1].properties[1].value" Type="Bool">true</Property>
				<Property Name="Source[1].propertiesCount" Type="Int">2</Property>
				<Property Name="Source[1].sourceInclusion" Type="Str">Include</Property>
				<Property Name="Source[1].type" Type="Str">VI</Property>
				<Property Name="SourceCount" Type="Int">2</Property>
			</Item>
		</Item>
	</Item>
</Project>
