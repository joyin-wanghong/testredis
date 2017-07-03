package com.wh.testredis.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SerializeUtil
{
  private static Logger logger = LoggerFactory.getLogger(SerializeUtil.class);

  public static byte[] serialize(Object object)
  {
    if (object == null)
      return null;

    ObjectOutputStream oos = null;
    ByteArrayOutputStream baos = null;
    try
    {
      byte[] arrayOfByte1;
      baos = new ByteArrayOutputStream();
      oos = new ObjectOutputStream(baos);
      oos.writeObject(object);
      byte[] bytes = baos.toByteArray();
      return bytes;
    } catch (Exception e) {
      logger.error(String.format("CATHC EXCEPTION WHEN %s :", new Object[] { "SerializeUtil.serialize(Object)" }), e);
    } finally {
      try {
        oos.close();
        baos.close();
      } catch (IOException e) {
        logger.error(String.format("CATHC EXCEPTION WHEN %s :", new Object[] { "SerializeUtil.serialize(Object)" }), e);
      }
    }
    return null;
  }

  public static Object unserialize(byte[] bytes)
  {
    if (bytes == null)
      return null;

    ByteArrayInputStream bais = null;
    ObjectInputStream ois = null;
    BufferedInputStream bis = null;
    try
    {
      Object localObject1;
      bais = new ByteArrayInputStream(bytes);
      bis = new BufferedInputStream(bais);
      ois = new ObjectInputStream(bis);
      return ois.readObject();
    } catch (Exception e) {
      logger.error(String.format("CATHC EXCEPTION WHEN %s :", new Object[] { "SerializeUtil.unserialize(byte[])" }), e);
    } finally {
      try {
        ois.close();
        bis.close();
        bais.close();
      } catch (IOException e) {
        logger.error(String.format("CATHC EXCEPTION WHEN %s :", new Object[] { "SerializeUtil.unserialize(byte[])" }), e);
      }
    }
    return null;
  }

  public static void main(String[] xxx) {
    String x = "\\xac\\xed\\x00\\x05sr\\x00\\x17com.yxq.util.LimitQueue\\xf4\\xe4\\xcb>\\xf3(U\\x8f\\x02\\x00\\x02I\\x00\\x05limitL\\x00\\x04listt\\x00\\x10Ljava/util/List;xp\\x00\\x00\\x01\\xf4sr\\x00\\x13java.util.ArrayListx\\x81\\xd2\\x1d\\x99\\xc7a\\x9d\\x03\\x00\\x01I\\x00\\x04sizexp\\x00\\x00\\x00\\tw\\x04\\x00\\x00\\x00\\tsr\\x00\\x0ejava.lang.Long;\\x8b\\xe4\\x90\\xcc\\x8f#\\xdf\\x02\\x00\\x01J\\x00\\x05valuexr\\x00\\x10java.lang.Number\\x86\\xac\\x95\\x1d\\x0b\\x94\\xe0\\x8b\\x02\\x00\\x00xp\\x00\\x00\\x01S\\xefG\\x92\\x0esq\\x00~\\x00\\x05\\x00\\x00\\x01S\\xefH\\x01\\xdesq\\x00~\\x00\\x05\\x00\\x00\\x01S\\xefL\\x97Asq\\x00~\\x00\\x05\\x00\\x00\\x01S\\xefNd\\x0fsq\\x00~\\x00\\x05\\x00\\x00\\x01S\\xef~\\x99zsq\\x00~\\x00\\x05\\x00\\x00\\x01S\\xef~\\xc0isq\\x00~\\x00\\x05\\x00\\x00\\x01S\\xef\\x82\\xc1\\xc3sq\\x00~\\x00\\x05\\x00\\x00\\x01S\\xef\\x9b\\x87\\x1bsq\\x00~\\x00\\x05\\x00\\x00\\x01S\\xef\\xa1\\x9d\\xf8x";

    Object o = unserialize(x.getBytes());

    System.out.println(o.toString());
  }
}