<?xml version='1.0' encoding='UTF-8'?>
<Project Type="Project" LVVersion="15008000">
	<Property Name="CCSymbols" Type="Str"></Property>
	<Property Name="NI.LV.All.SourceOnly" Type="Bool">false</Property>
	<Property Name="NI.Project.Description" Type="Str">This example demonstrates how to control a simulated iRobot Create.</Property>
	<Property Name="SMProvider.SMVersion" Type="Int">201310</Property>
	<Item Name="My Computer" Type="My Computer">
		<Property Name="IOScan.Faults" Type="Str"></Property>
		<Property Name="IOScan.NetVarPeriod" Type="UInt">100</Property>
		<Property Name="IOScan.NetWatchdogEnabled" Type="Bool">false</Property>
		<Property Name="IOScan.Period" Type="UInt">10000</Property>
		<Property Name="IOScan.PowerupMode" Type="UInt">0</Property>
		<Property Name="IOScan.Priority" Type="UInt">9</Property>
		<Property Name="IOScan.ReportModeConflict" Type="Bool">true</Property>
		<Property Name="IOScan.StartEngineOnDeploy" Type="Bool">false</Property>
		<Property Name="NI.SortType" Type="Int">3</Property>
		<Property Name="server.app.propertiesEnabled" Type="Bool">true</Property>
		<Property Name="server.control.propertiesEnabled" Type="Bool">true</Property>
		<Property Name="server.tcp.enabled" Type="Bool">false</Property>
		<Property Name="server.tcp.port" Type="Int">0</Property>
		<Property Name="server.tcp.serviceName" Type="Str">My Computer/VI Server</Property>
		<Property Name="server.tcp.serviceName.default" Type="Str">My Computer/VI Server</Property>
		<Property Name="server.vi.callsEnabled" Type="Bool">true</Property>
		<Property Name="server.vi.propertiesEnabled" Type="Bool">true</Property>
		<Property Name="specify.custom.address" Type="Bool">false</Property>
		<Item Name="autograder" Type="Folder"/>
		<Item Name="build dependencies" Type="Folder">
			<Item Name="LVODE.dll" Type="Document" URL="/&lt;resource&gt;/LVODE.dll"/>
			<Item Name="ode.dll" Type="Document" URL="/&lt;resource&gt;/ode.dll"/>
			<Item Name="labview.lib" Type="Document" URL="../../../../../../../../../../Program Files (x86)/National Instruments/LabVIEW 2015/cintools/labview.lib"/>
			<Item Name="labviewv.lib" Type="Document" URL="../../../../../../../../../../Program Files (x86)/National Instruments/LabVIEW 2015/cintools/labviewv.lib"/>
		</Item>
		<Item Name="CyberSim interface" Type="Folder">
			<Item Name="Simulation Configuration.ctl" Type="VI" URL="../../CyberSim interface/Simulation Configuration.ctl"/>
		</Item>
		<Item Name="CyberSim" Type="Folder">
			<Item Name="simulation" Type="Folder">
				<Item Name="Simulation Kobuki Drive.vi" Type="VI" URL="../simulation/Simulation Kobuki Drive.vi"/>
				<Item Name="Simulation Kobuki Close.vi" Type="VI" URL="../simulation/Simulation Kobuki Close.vi"/>
				<Item Name="Simulation Call Statechart (DLL).vi" Type="VI" URL="../simulation/Simulation Call Statechart (DLL).vi"/>
				<Item Name="Simulation Call Statechart (VI).vi" Type="VI" URL="../simulation/Simulation Call Statechart (VI).vi"/>
				<Item Name="Simulation Call Statechart Operation.ctl" Type="VI" URL="../simulation/Simulation Call Statechart Operation.ctl"/>
				<Item Name="Simulation Call Statechart.vi" Type="VI" URL="../simulation/Simulation Call Statechart.vi"/>
				<Item Name="Simulation Configuration from Command-Line.vi" Type="VI" URL="../simulation/Simulation Configuration from Command-Line.vi"/>
				<Item Name="Simulation Configuration Read If Present.vi" Type="VI" URL="../simulation/Simulation Configuration Read If Present.vi"/>
				<Item Name="Simulation Configuration Read.vi" Type="VI" URL="../simulation/Simulation Configuration Read.vi"/>
				<Item Name="Simulation Configuration Write.vi" Type="VI" URL="../simulation/Simulation Configuration Write.vi"/>
				<Item Name="Simulation Execution Mode.ctl" Type="VI" URL="../simulation/Simulation Execution Mode.ctl"/>
				<Item Name="Simulation Finalize.vi" Type="VI" URL="../simulation/Simulation Finalize.vi"/>
				<Item Name="Simulation Full Step.vi" Type="VI" URL="../simulation/Simulation Full Step.vi"/>
				<Item Name="Simulation Initialize.vi" Type="VI" URL="../simulation/Simulation Initialize.vi"/>
				<Item Name="Simulation Kobuki Sensors.vi" Type="VI" URL="../simulation/Simulation Kobuki Sensors.vi"/>
				<Item Name="Simulation Record Get.vi" Type="VI" URL="../simulation/Simulation Record Get.vi"/>
				<Item Name="Simulation Record Read.vi" Type="VI" URL="../simulation/Simulation Record Read.vi"/>
				<Item Name="Simulation Record Write.vi" Type="VI" URL="../simulation/Simulation Record Write.vi"/>
				<Item Name="Simulation Record.ctl" Type="VI" URL="../simulation/Simulation Record.ctl"/>
				<Item Name="Simulation Robot Open.vi" Type="VI" URL="../simulation/Simulation Robot Open.vi"/>
				<Item Name="Simulation Statechart Template.vi" Type="VI" URL="../simulation/Simulation Statechart Template.vi"/>
				<Item Name="Simulation Statechart Type.ctl" Type="VI" URL="../simulation/Simulation Statechart Type.ctl"/>
				<Item Name="Simulation Time Advance.vi" Type="VI" URL="../simulation/Simulation Time Advance.vi"/>
				<Item Name="Simulation Time Elapsed.vi" Type="VI" URL="../simulation/Simulation Time Elapsed.vi"/>
				<Item Name="Simulation Trace Element.ctl" Type="VI" URL="../simulation/Simulation Trace Element.ctl"/>
				<Item Name="Simulation Trace Element.vi" Type="VI" URL="../simulation/Simulation Trace Element.vi"/>
				<Item Name="Simulation Trace Operation.ctl" Type="VI" URL="../simulation/Simulation Trace Operation.ctl"/>
				<Item Name="Simulation Trace.vi" Type="VI" URL="../simulation/Simulation Trace.vi"/>
				<Item Name="SimulationIDs.ctl" Type="VI" URL="../simulation/SimulationIDs.ctl"/>
				<Item Name="Simulator.ctl" Type="VI" URL="../simulation/Simulator.ctl"/>
				<Item Name="SimulatorHelperGetRobotsID.vi" Type="VI" URL="../simulation/SimulatorHelperGetRobotsID.vi"/>
			</Item>
		</Item>
		<Item Name="shared" Type="Folder" URL="../../shared">
			<Property Name="NI.DISK" Type="Bool">true</Property>
		</Item>
		<Item Name="system" Type="Folder">
			<Item Name="Command-Line Get Boolean Key.vi" Type="VI" URL="../../system/Command-Line Get Boolean Key.vi"/>
			<Item Name="Command-Line Get Numeric Key.vi" Type="VI" URL="../../system/Command-Line Get Numeric Key.vi"/>
			<Item Name="Command-Line Get String Key.vi" Type="VI" URL="../../system/Command-Line Get String Key.vi"/>
			<Item Name="Command-Line Parse All.vi" Type="VI" URL="../../system/Command-Line Parse All.vi"/>
			<Item Name="Path Resolve.vi" Type="VI" URL="../../system/Path Resolve.vi"/>
		</Item>
		<Item Name="Kobuki" Type="Folder" URL="../../Kobuki">
			<Property Name="NI.DISK" Type="Bool">true</Property>
		</Item>
		<Item Name="deploy" Type="Folder" URL="../../deploy">
			<Property Name="NI.DISK" Type="Bool">true</Property>
		</Item>
		<Item Name="CyberSim.vi" Type="VI" URL="../CyberSim.vi"/>
		<Item Name="Environment - obstacle south left" Type="Robotics Environment Simulator">
			<Item Name="Environment - obstacle south left.xml" Type="Document" URL="../Environment - obstacle south left.xml"/>
			<Item Name="Environment - obstacle south left ID List.txt" Type="Document" URL="../Environment - obstacle south left ID List.txt"/>
		</Item>
		<Item Name="Environment - obstacle south right" Type="Robotics Environment Simulator">
			<Item Name="Environment - obstacle south right.xml" Type="Document" URL="../Environment - obstacle south right.xml"/>
			<Item Name="Environment - obstacle south right ID List.txt" Type="Document" URL="../Environment - obstacle south right ID List.txt"/>
		</Item>
		<Item Name="Environment - obstacle east right" Type="Robotics Environment Simulator">
			<Item Name="Environment - obstacle east right.xml" Type="Document" URL="../Environment - obstacle east right.xml"/>
			<Item Name="Environment - obstacle east right ID List.txt" Type="Document" URL="../Environment - obstacle east right ID List.txt"/>
		</Item>
		<Item Name="Environment - south ramp left" Type="Robotics Environment Simulator">
			<Item Name="Environment - south ramp left.xml" Type="Document" URL="../Environment - south ramp left.xml"/>
			<Item Name="Environment - south ramp left ID List.txt" Type="Document" URL="../Environment - south ramp left ID List.txt"/>
		</Item>
		<Item Name="Environment - east ramp obstacle" Type="Robotics Environment Simulator">
			<Item Name="Environment - east ramp obstacle.xml" Type="Document" URL="../Environment - east ramp obstacle.xml"/>
			<Item Name="Environment - east ramp obstacle ID List.txt" Type="Document" URL="../Environment - east ramp obstacle ID List.txt"/>
		</Item>
		<Item Name="Environment - south ramp right" Type="Robotics Environment Simulator">
			<Item Name="Environment - south ramp right.xml" Type="Document" URL="../Environment - south ramp right.xml"/>
			<Item Name="Environment - south ramp right ID List.txt" Type="Document" URL="../Environment - south ramp right ID List.txt"/>
		</Item>
		<Item Name="Environment - Navigation and Hill Climb 1" Type="Robotics Environment Simulator">
			<Item Name="Environment - Navigation and Hill Climb 1.xml" Type="Document" URL="../Environment - Navigation and Hill Climb 1.xml"/>
			<Item Name="Environment - Navigation and Hill Climb 1.vi" Type="VI" URL="../Environment - Navigation and Hill Climb 1.vi"/>
			<Item Name="Environment - Navigation and Hill Climb 1 ID List.txt" Type="Document" URL="../Environment - Navigation and Hill Climb 1 ID List.txt"/>
		</Item>
		<Item Name="Environment - short obstacle front" Type="Robotics Environment Simulator">
			<Item Name="Environment - short obstacle front.xml" Type="Document" URL="../Environment - short obstacle front.xml"/>
			<Item Name="Environment - short obstacle front.vi" Type="VI" URL="../Environment - short obstacle front.vi"/>
			<Item Name="Environment - short obstacle front ID List.txt" Type="Document" URL="../Environment - short obstacle front ID List.txt"/>
		</Item>
		<Item Name="Environment - short obstacle left" Type="Robotics Environment Simulator">
			<Item Name="Environment - short obstacle left.xml" Type="Document" URL="../Environment - short obstacle left.xml"/>
			<Item Name="Environment - short obstacle left.vi" Type="VI" URL="../Environment - short obstacle left.vi"/>
			<Item Name="Environment - short obstacle left ID List.txt" Type="Document" URL="../Environment - short obstacle left ID List.txt"/>
		</Item>
		<Item Name="Environment - short obstacle right" Type="Robotics Environment Simulator">
			<Item Name="Environment - short obstacle right.xml" Type="Document" URL="../Environment - short obstacle right.xml"/>
			<Item Name="Environment - short obstacle right.vi" Type="VI" URL="../Environment - short obstacle right.vi"/>
			<Item Name="Environment - short obstacle right ID List.txt" Type="Document" URL="../Environment - short obstacle right ID List.txt"/>
		</Item>
		<Item Name="Environment - obstacle front" Type="Robotics Environment Simulator">
			<Item Name="Environment - obstacle front.xml" Type="Document" URL="../Environment - obstacle front.xml"/>
			<Item Name="Environment - obstacle front.vi" Type="VI" URL="../Environment - obstacle front.vi"/>
			<Item Name="Environment - obstacle front ID List.txt" Type="Document" URL="../Environment - obstacle front ID List.txt"/>
		</Item>
		<Item Name="Environment - obstacle left" Type="Robotics Environment Simulator">
			<Item Name="Environment - obstacle left.xml" Type="Document" URL="../Environment - obstacle left.xml"/>
			<Item Name="Environment - obstacle left.vi" Type="VI" URL="../Environment - obstacle left.vi"/>
			<Item Name="Environment - obstacle left ID List.txt" Type="Document" URL="../Environment - obstacle left ID List.txt"/>
		</Item>
		<Item Name="Environment - obstacle right" Type="Robotics Environment Simulator">
			<Item Name="Environment - obstacle right.xml" Type="Document" URL="../Environment - obstacle right.xml"/>
			<Item Name="Environment - obstacle right.vi" Type="VI" URL="../Environment - obstacle right.vi"/>
			<Item Name="Environment - obstacle right ID List.txt" Type="Document" URL="../Environment - obstacle right ID List.txt"/>
		</Item>
		<Item Name="Environment - Navigation Maze 1" Type="Robotics Environment Simulator">
			<Item Name="Environment - Navigation Maze 1.xml" Type="Document" URL="../Environment - Navigation Maze 1.xml"/>
			<Item Name="Robotics Environment Simulator.vi" Type="VI" URL="../Robotics Environment Simulator.vi"/>
			<Item Name="Environment - Navigation Maze 1 ID List.txt" Type="Document" URL="../Environment - Navigation Maze 1 ID List.txt"/>
		</Item>
		<Item Name="Dependencies" Type="Dependencies">
			<Item Name="vi.lib" Type="Folder">
				<Item Name="Application Directory.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/file.llb/Application Directory.vi"/>
				<Item Name="BuildHelpPath.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/BuildHelpPath.vi"/>
				<Item Name="Check if File or Folder Exists.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/libraryn.llb/Check if File or Folder Exists.vi"/>
				<Item Name="Check Special Tags.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Check Special Tags.vi"/>
				<Item Name="Clear Errors.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Clear Errors.vi"/>
				<Item Name="Convert property node font to graphics font.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Convert property node font to graphics font.vi"/>
				<Item Name="Details Display Dialog.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Details Display Dialog.vi"/>
				<Item Name="DialogType.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/DialogType.ctl"/>
				<Item Name="DialogTypeEnum.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/DialogTypeEnum.ctl"/>
				<Item Name="Error Cluster From Error Code.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Error Cluster From Error Code.vi"/>
				<Item Name="Error Code Database.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Error Code Database.vi"/>
				<Item Name="ErrWarn.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/ErrWarn.ctl"/>
				<Item Name="eventvkey.ctl" Type="VI" URL="/&lt;vilib&gt;/event_ctls.llb/eventvkey.ctl"/>
				<Item Name="Find Tag.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Find Tag.vi"/>
				<Item Name="Format Message String.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Format Message String.vi"/>
				<Item Name="General Error Handler.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/General Error Handler.vi"/>
				<Item Name="Get String Text Bounds.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Get String Text Bounds.vi"/>
				<Item Name="Get Text Rect.vi" Type="VI" URL="/&lt;vilib&gt;/picture/picture.llb/Get Text Rect.vi"/>
				<Item Name="GetHelpDir.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/GetHelpDir.vi"/>
				<Item Name="GetRTHostConnectedProp.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/GetRTHostConnectedProp.vi"/>
				<Item Name="Longest Line Length in Pixels.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Longest Line Length in Pixels.vi"/>
				<Item Name="LVBoundsTypeDef.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/miscctls.llb/LVBoundsTypeDef.ctl"/>
				<Item Name="LVRectTypeDef.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/miscctls.llb/LVRectTypeDef.ctl"/>
				<Item Name="NI_FileType.lvlib" Type="Library" URL="/&lt;vilib&gt;/Utility/lvfile.llb/NI_FileType.lvlib"/>
				<Item Name="NI_PackedLibraryUtility.lvlib" Type="Library" URL="/&lt;vilib&gt;/Utility/LVLibp/NI_PackedLibraryUtility.lvlib"/>
				<Item Name="Not Found Dialog.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Not Found Dialog.vi"/>
				<Item Name="Search and Replace Pattern.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Search and Replace Pattern.vi"/>
				<Item Name="Set Bold Text.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Set Bold Text.vi"/>
				<Item Name="Set String Value.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Set String Value.vi"/>
				<Item Name="Simple Error Handler.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Simple Error Handler.vi"/>
				<Item Name="TagReturnType.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/TagReturnType.ctl"/>
				<Item Name="Three Button Dialog CORE.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Three Button Dialog CORE.vi"/>
				<Item Name="Three Button Dialog.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Three Button Dialog.vi"/>
				<Item Name="Trim Whitespace.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Trim Whitespace.vi"/>
				<Item Name="whitespace.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/whitespace.ctl"/>
				<Item Name="General Error Handler Core CORE.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/General Error Handler Core CORE.vi"/>
				<Item Name="GetTargetBuildSpecs (project reference).vi" Type="VI" URL="/&lt;vilib&gt;/AppBuilder/GetTargetBuildSpecs (project reference).vi"/>
				<Item Name="GetTargetBuildSpecs.vi" Type="VI" URL="/&lt;vilib&gt;/AppBuilder/GetTargetBuildSpecs.vi"/>
				<Item Name="NI_App_Builder_API.lvlib" Type="Library" URL="/&lt;vilib&gt;/AppBuilder/AB_API_Simple/NI_App_Builder_API.lvlib"/>
				<Item Name="8.6CompatibleGlobalVar.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/config.llb/8.6CompatibleGlobalVar.vi"/>
				<Item Name="Empty Picture" Type="VI" URL="/&lt;vilib&gt;/picture/picture.llb/Empty Picture"/>
				<Item Name="MD5Checksum core.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/MD5Checksum.llb/MD5Checksum core.vi"/>
				<Item Name="MD5Checksum File.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/MD5Checksum.llb/MD5Checksum File.vi"/>
				<Item Name="MD5Checksum format message-digest.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/MD5Checksum.llb/MD5Checksum format message-digest.vi"/>
				<Item Name="MD5Checksum pad.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/MD5Checksum.llb/MD5Checksum pad.vi"/>
				<Item Name="NI_LVConfig.lvlib" Type="Library" URL="/&lt;vilib&gt;/Utility/config.llb/NI_LVConfig.lvlib"/>
				<Item Name="SCRT Dbg Rtn.vi" Type="VI" URL="/&lt;vilib&gt;/Statechart/Infrastructure/RTStatechart/Dbg/SCRT Dbg Rtn.vi"/>
				<Item Name="SCRT SDV Rtn.vi" Type="VI" URL="/&lt;vilib&gt;/Statechart/Infrastructure/RTStatechart/Dbg/SCRT SDV Rtn.vi"/>
				<Item Name="Space Constant.vi" Type="VI" URL="/&lt;vilib&gt;/dlg_ctls.llb/Space Constant.vi"/>
				<Item Name="Write to XML File(array).vi" Type="VI" URL="/&lt;vilib&gt;/Utility/xml.llb/Write to XML File(array).vi"/>
				<Item Name="Write to XML File(string).vi" Type="VI" URL="/&lt;vilib&gt;/Utility/xml.llb/Write to XML File(string).vi"/>
				<Item Name="Write to XML File.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/xml.llb/Write to XML File.vi"/>
				<Item Name="NI_AALBLAS.lvlib" Type="Library" URL="/&lt;vilib&gt;/Analysis/NI_AALBLAS.lvlib"/>
				<Item Name="NI_SC_LVSCCommonFiles.lvlib" Type="Library" URL="/&lt;vilib&gt;/Statechart/Common/NI_SC_LVSCCommonFiles.lvlib"/>
				<Item Name="compatCalcOffset.vi" Type="VI" URL="/&lt;vilib&gt;/_oldvers/_oldvers.llb/compatCalcOffset.vi"/>
				<Item Name="compatFileDialog.vi" Type="VI" URL="/&lt;vilib&gt;/_oldvers/_oldvers.llb/compatFileDialog.vi"/>
				<Item Name="compatOpenFileOperation.vi" Type="VI" URL="/&lt;vilib&gt;/_oldvers/_oldvers.llb/compatOpenFileOperation.vi"/>
				<Item Name="FindCloseTagByName.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/xml.llb/FindCloseTagByName.vi"/>
				<Item Name="FindElement.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/xml.llb/FindElement.vi"/>
				<Item Name="FindElementStartByName.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/xml.llb/FindElementStartByName.vi"/>
				<Item Name="FindEmptyElement.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/xml.llb/FindEmptyElement.vi"/>
				<Item Name="FindFirstTag.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/xml.llb/FindFirstTag.vi"/>
				<Item Name="FindMatchingCloseTag.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/xml.llb/FindMatchingCloseTag.vi"/>
				<Item Name="Get File Extension.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/libraryn.llb/Get File Extension.vi"/>
				<Item Name="Open_Create_Replace File.vi" Type="VI" URL="/&lt;vilib&gt;/_oldvers/_oldvers.llb/Open_Create_Replace File.vi"/>
				<Item Name="ParseXMLFragments.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/xml.llb/ParseXMLFragments.vi"/>
				<Item Name="Read From XML File(array).vi" Type="VI" URL="/&lt;vilib&gt;/Utility/xml.llb/Read From XML File(array).vi"/>
				<Item Name="Read From XML File(string).vi" Type="VI" URL="/&lt;vilib&gt;/Utility/xml.llb/Read From XML File(string).vi"/>
				<Item Name="Read From XML File.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/xml.llb/Read From XML File.vi"/>
				<Item Name="NI_AALPro.lvlib" Type="Library" URL="/&lt;vilib&gt;/Analysis/NI_AALPro.lvlib"/>
				<Item Name="NI_AAL_Angle.lvlib" Type="Library" URL="/&lt;vilib&gt;/Analysis/NI_AAL_Angle.lvlib"/>
				<Item Name="NI_Kinematics.lvlib" Type="Library" URL="/&lt;vilib&gt;/robotics/Kinematics/NI_Kinematics.lvlib"/>
				<Item Name="NI_Matrix.lvlib" Type="Library" URL="/&lt;vilib&gt;/Analysis/Matrix/NI_Matrix.lvlib"/>
				<Item Name="NI_Robotics_Simulator.lvlib" Type="Library" URL="/&lt;vilib&gt;/robotics/Simulator/NI_Robotics_Simulator.lvlib"/>
				<Item Name="LV3DPointTypeDef.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/miscctls.llb/LV3DPointTypeDef.ctl"/>
				<Item Name="NI_3D Picture Control.lvlib" Type="Library" URL="/&lt;vilib&gt;/picture/3D Picture Control/NI_3D Picture Control.lvlib"/>
				<Item Name="Dflt Data Dir.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/file.llb/Dflt Data Dir.vi"/>
				<Item Name="imagedata.ctl" Type="VI" URL="/&lt;vilib&gt;/picture/picture.llb/imagedata.ctl"/>
				<Item Name="Read PNG File.vi" Type="VI" URL="/&lt;vilib&gt;/picture/png.llb/Read PNG File.vi"/>
				<Item Name="Check Path.vi" Type="VI" URL="/&lt;vilib&gt;/picture/jpeg.llb/Check Path.vi"/>
				<Item Name="Directory of Top Level VI.vi" Type="VI" URL="/&lt;vilib&gt;/picture/jpeg.llb/Directory of Top Level VI.vi"/>
				<Item Name="Create Mask By Alpha.vi" Type="VI" URL="/&lt;vilib&gt;/picture/picture.llb/Create Mask By Alpha.vi"/>
				<Item Name="Bit-array To Byte-array.vi" Type="VI" URL="/&lt;vilib&gt;/picture/pictutil.llb/Bit-array To Byte-array.vi"/>
				<Item Name="NI_Robotics Utilities.lvlib" Type="Library" URL="/&lt;vilib&gt;/robotics/Utilities/NI_Robotics Utilities.lvlib"/>
				<Item Name="Read Characters From File.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/file.llb/Read Characters From File.vi"/>
				<Item Name="Open File+.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/file.llb/Open File+.vi"/>
				<Item Name="Read File+ (string).vi" Type="VI" URL="/&lt;vilib&gt;/Utility/file.llb/Read File+ (string).vi"/>
				<Item Name="compatReadText.vi" Type="VI" URL="/&lt;vilib&gt;/_oldvers/_oldvers.llb/compatReadText.vi"/>
				<Item Name="Close File+.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/file.llb/Close File+.vi"/>
				<Item Name="Find First Error.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/error.llb/Find First Error.vi"/>
				<Item Name="NI_AALBase.lvlib" Type="Library" URL="/&lt;vilib&gt;/Analysis/NI_AALBase.lvlib"/>
				<Item Name="NI_Gmath.lvlib" Type="Library" URL="/&lt;vilib&gt;/gmath/NI_Gmath.lvlib"/>
				<Item Name="NI_AngleManipulation.lvlib" Type="Library" URL="/&lt;vilib&gt;/Utility/AngleManip/NI_AngleManipulation.lvlib"/>
				<Item Name="RGB to Color.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/colorconv.llb/RGB to Color.vi"/>
				<Item Name="Color to RGB.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/colorconv.llb/Color to RGB.vi"/>
				<Item Name="Get LV Class Name.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/LVClass/Get LV Class Name.vi"/>
				<Item Name="LVRGBAColorTypeDef.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/miscctls.llb/LVRGBAColorTypeDef.ctl"/>
				<Item Name="Write To Spreadsheet File.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/file.llb/Write To Spreadsheet File.vi"/>
				<Item Name="Write To Spreadsheet File (DBL).vi" Type="VI" URL="/&lt;vilib&gt;/Utility/file.llb/Write To Spreadsheet File (DBL).vi"/>
				<Item Name="Write Spreadsheet String.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/file.llb/Write Spreadsheet String.vi"/>
				<Item Name="Write To Spreadsheet File (I64).vi" Type="VI" URL="/&lt;vilib&gt;/Utility/file.llb/Write To Spreadsheet File (I64).vi"/>
				<Item Name="Write To Spreadsheet File (string).vi" Type="VI" URL="/&lt;vilib&gt;/Utility/file.llb/Write To Spreadsheet File (string).vi"/>
				<Item Name="Read From Spreadsheet File.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/file.llb/Read From Spreadsheet File.vi"/>
				<Item Name="Read From Spreadsheet File (DBL).vi" Type="VI" URL="/&lt;vilib&gt;/Utility/file.llb/Read From Spreadsheet File (DBL).vi"/>
				<Item Name="Read Lines From File.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/file.llb/Read Lines From File.vi"/>
				<Item Name="Read From Spreadsheet File (I64).vi" Type="VI" URL="/&lt;vilib&gt;/Utility/file.llb/Read From Spreadsheet File (I64).vi"/>
				<Item Name="Read From Spreadsheet File (string).vi" Type="VI" URL="/&lt;vilib&gt;/Utility/file.llb/Read From Spreadsheet File (string).vi"/>
				<Item Name="NI_Robotics_Mecanum Wheel.lvclass" Type="LVClass" URL="/&lt;vilib&gt;/robotics/Steering/Mecanum Wheel/NI_Robotics_Mecanum Wheel.lvclass"/>
				<Item Name="NI_Robotics_Wheel.lvclass" Type="LVClass" URL="/&lt;vilib&gt;/robotics/Steering/Wheel/NI_Robotics_Wheel.lvclass"/>
				<Item Name="NI_Robotics_Motor Communication.lvclass" Type="LVClass" URL="/&lt;vilib&gt;/robotics/Actuation/Motor Communication/NI_Robotics_Motor Communication.lvclass"/>
				<Item Name="NI_Robotics_Motor Communication Ref.lvclass" Type="LVClass" URL="/&lt;vilib&gt;/robotics/Actuation/Motor Communication Ref/NI_Robotics_Motor Communication Ref.lvclass"/>
				<Item Name="NI_Robotics_Motor Communication Val.lvclass" Type="LVClass" URL="/&lt;vilib&gt;/robotics/Actuation/Motor Communication Val/NI_Robotics_Motor Communication Val.lvclass"/>
				<Item Name="NI_Robotics_Fixed Wheel.lvclass" Type="LVClass" URL="/&lt;vilib&gt;/robotics/Steering/Fixed Wheel/NI_Robotics_Fixed Wheel.lvclass"/>
				<Item Name="NI_Robotics_Steering Wheel.lvclass" Type="LVClass" URL="/&lt;vilib&gt;/robotics/Steering/Steering Wheel/NI_Robotics_Steering Wheel.lvclass"/>
				<Item Name="NI_Robotics_Caster Wheel.lvclass" Type="LVClass" URL="/&lt;vilib&gt;/robotics/Steering/Caster Wheel/NI_Robotics_Caster Wheel.lvclass"/>
				<Item Name="NI_Robotics_Omnidirectional Wheel.lvclass" Type="LVClass" URL="/&lt;vilib&gt;/robotics/Steering/Omnidirectional Wheel/NI_Robotics_Omnidirectional Wheel.lvclass"/>
				<Item Name="Get LV Class Default Value.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/LVClass/Get LV Class Default Value.vi"/>
				<Item Name="Recursive File List.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/libraryn.llb/Recursive File List.vi"/>
				<Item Name="List Directory and LLBs.vi" Type="VI" URL="/&lt;vilib&gt;/Utility/libraryn.llb/List Directory and LLBs.vi"/>
				<Item Name="VISA Configure Serial Port" Type="VI" URL="/&lt;vilib&gt;/Instr/_visa.llb/VISA Configure Serial Port"/>
				<Item Name="VISA Configure Serial Port (Instr).vi" Type="VI" URL="/&lt;vilib&gt;/Instr/_visa.llb/VISA Configure Serial Port (Instr).vi"/>
				<Item Name="VISA Configure Serial Port (Serial Instr).vi" Type="VI" URL="/&lt;vilib&gt;/Instr/_visa.llb/VISA Configure Serial Port (Serial Instr).vi"/>
				<Item Name="VISA Flush IO Buffer Mask.ctl" Type="VI" URL="/&lt;vilib&gt;/Instr/_visa.llb/VISA Flush IO Buffer Mask.ctl"/>
				<Item Name="LVPositionTypeDef.ctl" Type="VI" URL="/&lt;vilib&gt;/Utility/miscctls.llb/LVPositionTypeDef.ctl"/>
				<Item Name="UART.lvlib" Type="Library" URL="/&lt;vilib&gt;/myRIO/Instrument Drivers/Onboard IO/UART/UART.lvlib"/>
				<Item Name="AB_Generate_Error_Cluster.vi" Type="VI" URL="/&lt;vilib&gt;/AppBuilder/AB_Generate_Error_Cluster.vi"/>
			</Item>
			<Item Name="instr.lib" Type="Folder">
				<Item Name="DC Motor Controller.lvclass" Type="LVClass" URL="/&lt;instrlib&gt;/DC Motor Controller/HAIOL/DC Motor Controller.lvclass"/>
				<Item Name="DC Motor Controller Simulator.lvclass" Type="LVClass" URL="/&lt;instrlib&gt;/DC Motor Controller/HAIOL/Simulator/DC Motor Controller Simulator.lvclass"/>
			</Item>
			<Item Name="provcom_GenerateGUID.vi" Type="VI" URL="/&lt;resource&gt;/Framework/Providers/Common/provcom_GenerateGUID.vi"/>
			<Item Name="mxLvGenerateGuid.vi" Type="VI" URL="/&lt;resource&gt;/Framework/Providers/API/mxLvGenerateGuid.vi"/>
			<Item Name="mxLvErrorHandler.vi" Type="VI" URL="/&lt;resource&gt;/Framework/Providers/API/mxLvErrorHandler.vi"/>
			<Item Name="mxLvDebugDisplayCaller.vi" Type="VI" URL="/&lt;resource&gt;/Framework/Providers/API/mxLvDebugDisplayCaller.vi"/>
			<Item Name="LVODE.dll" Type="Document" URL="LVODE.dll">
				<Property Name="NI.PreserveRelativePath" Type="Bool">true</Property>
			</Item>
			<Item Name="lvanlys.dll" Type="Document" URL="/&lt;resource&gt;/lvanlys.dll"/>
			<Item Name="mxLvProvider.mxx" Type="Document" URL="/&lt;resource&gt;/Framework/Providers/mxLvProvider.mxx"/>
			<Item Name="ode.dll" Type="Document" URL="ode.dll">
				<Property Name="NI.PreserveRelativePath" Type="Bool">true</Property>
			</Item>
			<Item Name="lvblas.dll" Type="Document" URL="/&lt;resource&gt;/lvblas.dll"/>
			<Item Name="agLabviewFinalize.vi" Type="VI" URL="../autograder/agLabviewFinalize.vi"/>
			<Item Name="agLabviewGetErrorStatus.vi" Type="VI" URL="../autograder/agLabviewGetErrorStatus.vi"/>
			<Item Name="agLabviewGetNextTest.vi" Type="VI" URL="../autograder/agLabviewGetNextTest.vi"/>
			<Item Name="agLabviewGetReport.vi" Type="VI" URL="../autograder/agLabviewGetReport.vi"/>
			<Item Name="agLabviewInitialize.vi" Type="VI" URL="../autograder/agLabviewInitialize.vi"/>
			<Item Name="agLabviewInteractiveStatechartCalled.vi" Type="VI" URL="../autograder/agLabviewInteractiveStatechartCalled.vi"/>
			<Item Name="agLabviewInteractiveTimeAdvanced.vi" Type="VI" URL="../autograder/agLabviewInteractiveTimeAdvanced.vi"/>
			<Item Name="agLabviewIsTestQueueEmpty.vi" Type="VI" URL="../autograder/agLabviewIsTestQueueEmpty.vi"/>
			<Item Name="agLabviewSimulationRecorded.vi" Type="VI" URL="../autograder/agLabviewSimulationRecorded.vi"/>
			<Item Name="agLabviewUpdateConsole.vi" Type="VI" URL="../autograder/agLabviewUpdateConsole.vi"/>
			<Item Name="feedbackMode.ctl" Type="VI" URL="../autograder/feedbackMode.ctl"/>
			<Item Name="libAgLabviewPath.vi" Type="VI" URL="../autograder/libAgLabviewPath.vi"/>
			<Item Name="RobotOpen.vi" Type="VI" URL="../../system/RobotOpen.vi"/>
			<Item Name="RobotType.ctl" Type="VI" URL="../../system/RobotType.ctl"/>
			<Item Name="RobotData.ctl" Type="VI" URL="../Multi Bot Code/RobotData.ctl"/>
			<Item Name="Sim Sensors Feedback.ctl" Type="VI" URL="../Multi Bot Code/Sim Sensors Feedback.ctl"/>
			<Item Name="Filter Multi DLL (SubVI).vi" Type="VI" URL="../Multi Bot Code/Filter Multi DLL (SubVI).vi"/>
			<Item Name="GetMultiBotIDs.vi" Type="VI" URL="../Multi Bot Code/GetMultiBotIDs.vi"/>
			<Item Name="SensorType.ctl" Type="VI" URL="../Multi Bot Code/SensorType.ctl"/>
			<Item Name="GetSensorType(hackversion).vi" Type="VI" URL="../Multi Bot Code/GetSensorType(hackversion).vi"/>
			<Item Name="Simulated Position.ctl" Type="VI" URL="../simulation/Simulated Position.ctl"/>
			<Item Name="Simulated Orientation.ctl" Type="VI" URL="../simulation/Simulated Orientation.ctl"/>
			<Item Name="provcom_StringGlobals.vi" Type="VI" URL="/&lt;resource&gt;/Framework/Providers/Common/provcom_StringGlobals.vi"/>
		</Item>
		<Item Name="Build Specifications" Type="Build">
			<Item Name="CyberSim.exe" Type="EXE">
				<Property Name="App_copyErrors" Type="Bool">true</Property>
				<Property Name="App_INI_aliasGUID" Type="Str">{EC807AC4-9683-4C56-A6DC-869038F9DA12}</Property>
				<Property Name="App_INI_GUID" Type="Str">{7F7CC51A-B12A-4189-B8C6-219A8A9A0DD0}</Property>
				<Property Name="App_serverConfig.httpPort" Type="Int">8002</Property>
				<Property Name="Bld_autoIncrement" Type="Bool">true</Property>
				<Property Name="Bld_buildCacheID" Type="Str">{1DC7D3B5-D2E4-4579-84D7-99490CB7F34F}</Property>
				<Property Name="Bld_buildSpecName" Type="Str">CyberSim.exe</Property>
				<Property Name="Bld_compilerOptLevel" Type="Int">0</Property>
				<Property Name="Bld_excludeInlineSubVIs" Type="Bool">true</Property>
				<Property Name="Bld_excludeLibraryItems" Type="Bool">true</Property>
				<Property Name="Bld_excludePolymorphicVIs" Type="Bool">true</Property>
				<Property Name="Bld_localDestDir" Type="Path">/C/Users/gilled/Downloads/EmbeddedLab_v1.70_Courseware-Kobuki/EmbeddedLab_v1.70_Courseware/Courseware/outputTemp/CyperSim</Property>
				<Property Name="Bld_modifyLibraryFile" Type="Bool">true</Property>
				<Property Name="Bld_previewCacheID" Type="Str">{A8563109-BAD7-4FC0-BE24-2531E02D9613}</Property>
				<Property Name="Bld_version.build" Type="Int">105</Property>
				<Property Name="Bld_version.major" Type="Int">1</Property>
				<Property Name="Destination[0].destName" Type="Str">CyberSim.exe</Property>
				<Property Name="Destination[0].path" Type="Path">/C/Users/gilled/Downloads/EmbeddedLab_v1.70_Courseware-Kobuki/EmbeddedLab_v1.70_Courseware/Courseware/outputTemp/CyperSim/NI_AB_PROJECTNAME.exe</Property>
				<Property Name="Destination[0].path.type" Type="Str">&lt;none&gt;</Property>
				<Property Name="Destination[0].preserveHierarchy" Type="Bool">true</Property>
				<Property Name="Destination[0].type" Type="Str">App</Property>
				<Property Name="Destination[1].destName" Type="Str">Support Directory</Property>
				<Property Name="Destination[1].path" Type="Path">/C/Users/gilled/Downloads/EmbeddedLab_v1.70_Courseware-Kobuki/EmbeddedLab_v1.70_Courseware/Courseware/outputTemp/CyperSim/data</Property>
				<Property Name="Destination[1].path.type" Type="Str">&lt;none&gt;</Property>
				<Property Name="DestinationCount" Type="Int">2</Property>
				<Property Name="Exe_cmdLineArgs" Type="Bool">true</Property>
				<Property Name="Source[0].itemID" Type="Str">{F71C7D67-D2CB-47B2-9BDE-1F3C9745007F}</Property>
				<Property Name="Source[0].type" Type="Str">Container</Property>
				<Property Name="Source[1].Container.applyDestination" Type="Bool">true</Property>
				<Property Name="Source[1].Container.applyInclusion" Type="Bool">true</Property>
				<Property Name="Source[1].destinationIndex" Type="Int">0</Property>
				<Property Name="Source[1].itemID" Type="Ref">/My Computer/build dependencies</Property>
				<Property Name="Source[1].sourceInclusion" Type="Str">Include</Property>
				<Property Name="Source[1].type" Type="Str">Container</Property>
				<Property Name="Source[2].destinationIndex" Type="Int">0</Property>
				<Property Name="Source[2].itemID" Type="Ref">/My Computer/CyberSim.vi</Property>
				<Property Name="Source[2].properties[0].type" Type="Str">Allow debugging</Property>
				<Property Name="Source[2].properties[0].value" Type="Bool">false</Property>
				<Property Name="Source[2].propertiesCount" Type="Int">1</Property>
				<Property Name="Source[2].sourceInclusion" Type="Str">TopLevel</Property>
				<Property Name="Source[2].type" Type="Str">VI</Property>
				<Property Name="Source[3].Container.applyProperties" Type="Bool">true</Property>
				<Property Name="Source[3].Container.applySaveSettings" Type="Bool">true</Property>
				<Property Name="Source[3].itemID" Type="Ref">/My Computer/autograder</Property>
				<Property Name="Source[3].properties[0].type" Type="Str">Remove front panel</Property>
				<Property Name="Source[3].properties[0].value" Type="Bool">true</Property>
				<Property Name="Source[3].properties[1].type" Type="Str">Remove block diagram</Property>
				<Property Name="Source[3].properties[1].value" Type="Bool">true</Property>
				<Property Name="Source[3].properties[2].type" Type="Str">Allow debugging</Property>
				<Property Name="Source[3].properties[2].value" Type="Bool">true</Property>
				<Property Name="Source[3].propertiesCount" Type="Int">3</Property>
				<Property Name="Source[3].type" Type="Str">Container</Property>
				<Property Name="SourceCount" Type="Int">4</Property>
				<Property Name="TgtF_companyName" Type="Str">National Instruments</Property>
				<Property Name="TgtF_fileDescription" Type="Str">CyberSim.exe</Property>
				<Property Name="TgtF_internalName" Type="Str">CyberSim.exe</Property>
				<Property Name="TgtF_legalCopyright" Type="Str">Copyright © 2013 National Instruments</Property>
				<Property Name="TgtF_productName" Type="Str">CyberSim.exe</Property>
				<Property Name="TgtF_targetfileGUID" Type="Str">{4F58FF14-58B3-4622-9D21-561D083DB6F6}</Property>
				<Property Name="TgtF_targetfileName" Type="Str">CyberSim.exe</Property>
			</Item>
		</Item>
	</Item>
</Project>
