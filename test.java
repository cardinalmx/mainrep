import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import ru.diasoft.core.application.dto.AbstractTransferObject;
import ru.diasoft.core.application.dto.meta.MetaObject;
import ru.diasoft.core.application.dto.meta.MetaObjectAttribute;
import ru.diasoft.flextera.ftsched.utils.LogExt;
import ru.diasoft.utils.XMLUtil;

/** Тестокоммент### */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(
	name = "BaseOutput",
	propOrder = {
		"processID",
		"notificationList",
		"returnCode",
		"returnMsg" ,
		"wtf"
	}
)
public class BaseOutput extends AbstractTransferObject {

	private static final long serialVersionUID = 1L;

	/** Èäåíòèôèêàòîð ïðîöåññà */
	public static final String PROPERTY_PROCESS_ID = "ProcessID";

	/** Ñïèñîê îøèáîê */
	public static final String PROPERTY_NOTIFICATION_LIST = "NotificationList";

	/** Êîä ñîîáùåíèÿ îá îøèáêå */
	public static final String PROPERTY_RETURN_CODE = "ReturnCode";

	/** Òåêñò ñîîáùåíèÿ îá îøèáêå */
	public static final String PROPERTY_RETURN_MSG = "ReturnMsg";

	//------------------------------------------------------------

	private static final MetaObject INFO = new MetaObject(
		BaseOutput.class.getName(),
		new MetaObjectAttribute(PROPERTY_PROCESS_ID, Long.class, false, false, false),
		new MetaObjectAttribute(PROPERTY_NOTIFICATION_LIST, BaseNotificationList.class, true, false, false),
		new MetaObjectAttribute(PROPERTY_RETURN_CODE, Long.class, false, false),
		new MetaObjectAttribute(PROPERTY_RETURN_MSG, String.class, false, false)
	);

	//------------------------------------------------------------

	/**
	 * Âûõîäíûå ïàðàìåòðû âíåøíåé ÀÏÈ
	 */
    public BaseOutput(){
		super( INFO );
	}

    //------------------------------------------------------------

    /** Èäåíòèôèêàòîð ïðîöåññà */
	@XmlElement(name = PROPERTY_PROCESS_ID, required = false)
	public Long getProcessID() {
		return getProperty( PROPERTY_PROCESS_ID );
	}

	//------------------------------------------------------------

	/** Ñïèñîê îøèáîê */
	@XmlElement(name = PROPERTY_NOTIFICATION_LIST, required = false)
	public List<BaseNotificationList> getNotificationList(){
		return getProperty( PROPERTY_NOTIFICATION_LIST );
	}

	//------------------------------------------------------------

	/** Êîä ñîîáùåíèÿ îá îøèáêå */
	@XmlElement(name = PROPERTY_RETURN_CODE, required = false)
	public Long getReturnCode(){
		return getProperty( PROPERTY_RETURN_CODE );
	}

	/** Êîä ñîîáùåíèÿ îá îøèáêå */
	public void setReturnCode( Long returnCode ){
		setProperty( PROPERTY_RETURN_CODE, returnCode );
	}

	//------------------------------------------------------------

	/** Òåêñò ñîîáùåíèÿ îá îøèáêå */
	@XmlElement(name = PROPERTY_RETURN_MSG, required = false)
	public String getReturnMsg(){
		return getProperty( PROPERTY_RETURN_MSG );
	}

	/** Òåêñò ñîîáùåíèÿ îá îøèáêå */
	public void setReturnMsg( String returnMsg ){
		setProperty( PROPERTY_RETURN_MSG, returnMsg );
	}

	//------------------------------------------------------------

	/**
	 * TODO JavaDoc
	 */
	@SuppressWarnings("unchecked")
	public static BaseOutput fromResultMap( Map<String,Object> output ){
		BaseOutput baseOutput = null;
		if( output != null ){

			try{
				// Õîòÿ ìû ïðîñèëè íå îáîðà÷èâàòü îòâåò â Result-îá¸ðòêó, ýòî âñ¸ æå ìîãëî ïðîèçîéòè.
				// Èçâëå÷¸ì ðåçóëüòàò.
				if( output.containsKey(XMLUtil.RET_RESULT) ){
					output = (Map<String,Object>)output.get( XMLUtil.RET_RESULT );
					
					if( output != null ){
						baseOutput = new BaseOutput();
						baseOutput.fromMap( output );
				}	}
				else{
					baseOutput = new BaseOutput();
					baseOutput.fromMap( output );
			}	}
			catch( Exception exception ){
				LogExt.error( exception );
		}	}
		return baseOutput;
	}

	//------------------------------------------------------------

	/** Êîä óñïåøíîãî âûçîâà ÀÏÈ */
	public static final Long RET_CODE_SUCCESS = 0L;
}
