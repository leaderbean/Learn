package com.king.learn.app.utils;

import android.database.Cursor;
import android.text.TextUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * <请描述这个类是干什么的>
 */

public class IOUtil
{
    private IOUtil()
    {
    }

    public static void closeQuietly(Closeable closeable)
    {
        if (closeable != null)
        {
            try
            {
                closeable.close();
            } catch (Throwable ignored)
            {
            }
        }
    }

    public static void closeQuietly(Cursor cursor)
    {
        if (cursor != null)
        {
            try
            {
                cursor.close();
            } catch (Throwable ignored)
            {
            }
        }
    }

    public static byte[] readBytes(InputStream in) throws IOException
    {
        if (!(in instanceof BufferedInputStream))
        {
            in = new BufferedInputStream(in);
        }
        ByteArrayOutputStream out = null;
        try
        {
            out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) != -1)
            {
                out.write(buf, 0, len);
            }
            return out.toByteArray();
        } finally
        {
            closeQuietly(out);
        }
    }

    public static byte[] readBytes(InputStream in, long skip, long size) throws IOException
    {
        ByteArrayOutputStream out = null;
        try
        {
            if (skip > 0)
            {
                long skipSize = 0;
                while (skip > 0 && (skipSize = in.skip(skip)) > 0)
                {
                    skip -= skipSize;
                }
            }
            out = new ByteArrayOutputStream();
            for (int i = 0; i < size; i++)
            {
                out.write(in.read());
            }
            return out.toByteArray();
        } finally
        {
            closeQuietly(out);
        }
    }

    public static String readStr(InputStream in) throws IOException
    {
        return readStr(in, "UTF-8");
    }

    public static String readStr(InputStream in, String charset) throws IOException
    {
        if (TextUtils.isEmpty(charset)) charset = "UTF-8";

        if (!(in instanceof BufferedInputStream))
        {
            in = new BufferedInputStream(in);
        }
        Reader reader = new InputStreamReader(in, charset);
        StringBuilder sb = new StringBuilder();
        char[] buf = new char[1024];
        int len;
        while ((len = reader.read(buf)) >= 0)
        {
            sb.append(buf, 0, len);
        }
        return sb.toString();
    }

    public static void writeStr(OutputStream out, String str) throws IOException
    {
        writeStr(out, str, "UTF-8");
    }

    public static void writeStr(OutputStream out, String str, String charset) throws IOException
    {
        if (TextUtils.isEmpty(charset)) charset = "UTF-8";

        Writer writer = new OutputStreamWriter(out, charset);
        writer.write(str);
        writer.flush();
    }

    public static void copy(InputStream in, OutputStream out) throws IOException
    {
        if (!(in instanceof BufferedInputStream))
        {
            in = new BufferedInputStream(in);
        }
        if (!(out instanceof BufferedOutputStream))
        {
            out = new BufferedOutputStream(out);
        }
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = in.read(buffer)) != -1)
        {
            out.write(buffer, 0, len);
        }
        out.flush();
    }
}