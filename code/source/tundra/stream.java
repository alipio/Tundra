package tundra;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2016-05-25 14:14:30.027
// -----( ON-HOST: -

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import permafrost.tundra.io.CloseableHelper;
import permafrost.tundra.io.InputOutputHelper;
import permafrost.tundra.io.InputStreamHelper;
import permafrost.tundra.lang.BooleanHelper;
import permafrost.tundra.lang.CharsetHelper;
import permafrost.tundra.lang.ExceptionHelper;
// --- <<IS-END-IMPORTS>> ---

public final class stream

{
	// ---( internal utility methods )---

	final static stream _instance = new stream();

	static stream _newInstance() { return new stream(); }

	static stream _cast(Object o) { return (stream)o; }

	// ---( server methods )---




	public static final void close (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(close)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:optional $stream
		IDataCursor cursor = pipeline.getCursor();

		try {
		    Object stream = IDataUtil.get(cursor, "$stream");
		    if (stream instanceof Closeable) CloseableHelper.close((Closeable)stream);
		} finally {
		    cursor.destroy();
		}
		// --- <<IS-END>> ---


	}



	public static final void copy (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(copy)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:optional $input
		// [i] object:0:optional $output
		// [i] field:0:optional $close? {&quot;true&quot;,&quot;false&quot;}
		IDataCursor cursor = pipeline.getCursor();

		try {
		    Object input = IDataUtil.get(cursor, "$input");
		    Object output = IDataUtil.get(cursor, "$output");
		    boolean close = BooleanHelper.parse(IDataUtil.getString(cursor, "$close?"), true);
		    InputOutputHelper.copy(InputStreamHelper.normalize(input), (OutputStream)output, close);
		} catch(IOException ex) {
		    ExceptionHelper.raise(ex);
		} finally {
		    cursor.destroy();
		}
		// --- <<IS-END>> ---


	}



	public static final void normalize (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(normalize)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] object:0:optional $object
		// [i] field:0:optional $encoding
		// [o] object:0:optional $stream
		IDataCursor cursor = pipeline.getCursor();

		try {
		    Object object = IDataUtil.get(cursor, "$object");
		    Charset charset = CharsetHelper.normalize(IDataUtil.getString(cursor, "$encoding"));

		    IDataUtil.put(cursor, "$stream", InputStreamHelper.normalize(object, charset));
		} finally {
		    cursor.destroy();
		}
		// --- <<IS-END>> ---


	}
}

