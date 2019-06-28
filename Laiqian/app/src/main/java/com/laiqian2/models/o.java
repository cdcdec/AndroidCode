package com.laiqian.models;

import com.laiqian.basic.RootApplication;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.entity.p;
import com.laiqian.network.k;
import com.laiqian.pos.industry.a;
import com.laiqian.report.models.z;
import com.laiqian.util.av;
import com.laiqian.util.n;
import java.util.HashMap;
import java.util.List;

public class o {
  public z a(p paramp, String paramString) throws Exception {
    StringBuilder stringBuilder2;
    List list = b.g(n.parseLong(paramp.Fu()[0]), n.parseLong(paramp.Fu()[1]));
    z z = new z();
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(z.bsx);
    stringBuilder3.append("select _id,nDateTime,sOrderNo,nPayType,nStatus,fAmount,nUserID,sSpareField1 from(");
    z.bsx = stringBuilder3.toString();
    if (paramp.Ft().length == 1 && paramp.Ft()[0].intValue() == 1) {
      for (byte b = 0; b < list.size(); b++) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(z.bsx);
        stringBuilder2.append("select ");
        stringBuilder2.append((String)list.get(b));
        stringBuilder2.append(".t_accountdoc._id as _id,");
        stringBuilder2.append((String)list.get(b));
        stringBuilder2.append(".t_accountdoc.sSpareField1 as sSpareField1,");
        stringBuilder2.append((String)list.get(b));
        stringBuilder2.append(".t_accountdoc.nUserID as nUserID,");
        stringBuilder2.append((String)list.get(b));
        stringBuilder2.append(".t_accountdoc.nDateTime as nDateTime,");
        stringBuilder2.append((String)list.get(b));
        stringBuilder2.append(".t_accountdoc.sText as sOrderNo,");
        stringBuilder2.append((String)list.get(b));
        stringBuilder2.append(".t_accountdoc.nSpareField1 as nPayType,");
        stringBuilder2.append(1);
        stringBuilder2.append(" nStatus,");
        stringBuilder2.append((String)list.get(b));
        stringBuilder2.append(".t_accountdoc.fAccountAmount as fAmount from ");
        stringBuilder2.append((String)list.get(b));
        stringBuilder2.append(".t_accountdoc where ");
        stringBuilder2.append((String)list.get(b));
        stringBuilder2.append(".t_accountdoc.nShopID=? and ");
        stringBuilder2.append((String)list.get(b));
        stringBuilder2.append(".t_accountdoc.nAccountID in (10007,10009) and ");
        stringBuilder2.append((String)list.get(b));
        stringBuilder2.append(".t_accountdoc.nSpareField1 in ( ");
        z.bsx = stringBuilder2.toString();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(z.dcl);
        stringBuilder2.append(RootApplication.getLaiqianPreferenceManager().Tx());
        stringBuilder2.append(",");
        z.dcl = stringBuilder2.toString();
        byte b1;
        for (b1 = 0; b1 < paramp.Fs().length; b1++) {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(z.bsx);
          stringBuilder2.append("?,");
          z.bsx = stringBuilder2.toString();
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(z.dcl);
          stringBuilder2.append(paramp.Fs()[b1]);
          stringBuilder2.append(",");
          z.dcl = stringBuilder2.toString();
        } 
        z.bsx = z.bsx.substring(0, z.bsx.length() - 1);
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(z.bsx);
        stringBuilder2.append(") ");
        z.bsx = stringBuilder2.toString();
        if (paramp.getUserID() != null && Long.parseLong(paramp.getUserID()) > 0L) {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(z.bsx);
          stringBuilder2.append(" and nUserID=? ");
          z.bsx = stringBuilder2.toString();
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(z.dcl);
          stringBuilder2.append(paramp.getUserID());
          stringBuilder2.append(",");
          z.dcl = stringBuilder2.toString();
        } 
        if (paramp.Fu() != null) {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(z.bsx);
          stringBuilder2.append(" and (nDateTime between ? and ?) ");
          z.bsx = stringBuilder2.toString();
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(z.dcl);
          stringBuilder2.append(paramp.Fu()[0]);
          stringBuilder2.append(",");
          z.dcl = stringBuilder2.toString();
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(z.dcl);
          stringBuilder2.append(paramp.Fu()[1]);
          stringBuilder2.append(",");
          z.dcl = stringBuilder2.toString();
        } 
        if (b < list.size() - 1) {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(z.bsx);
          stringBuilder2.append(" union all ");
          z.bsx = stringBuilder2.toString();
        } 
      } 
    } else if (paramp.Ft().length == 1 && paramp.Ft()[0].intValue() != 1) {
      for (byte b = 0; b < list.size(); b++) {
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(z.bsx);
        stringBuilder3.append("select ");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc._id as _id,");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.sSpareField1 as sSpareField1,");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.nUserID as nUserID,");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.nDateTime as nDateTime,");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.sOrderNo as sOrderNo,");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.nPayType as nPayType,");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.nStatus as nStatus,");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.fPayAmount as fAmount from ");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc where (");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.nDeletionFlag is null or ");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.nDeletionFlag=0) and ");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.nSpareField1=");
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append(" and ");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.nShopID=?  and ");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.nPayType in ( ");
        z.bsx = stringBuilder3.toString();
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(z.dcl);
        stringBuilder3.append(RootApplication.getLaiqianPreferenceManager().Tx());
        stringBuilder3.append(",");
        z.dcl = stringBuilder3.toString();
        byte b1;
        for (b1 = 0; b1 < paramp.Fs().length; b1++) {
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.bsx);
          stringBuilder3.append("?,");
          z.bsx = stringBuilder3.toString();
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.dcl);
          stringBuilder3.append(paramp.Fs()[b1]);
          stringBuilder3.append(",");
          z.dcl = stringBuilder3.toString();
        } 
        z.bsx = z.bsx.substring(0, z.bsx.length() - 1);
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(z.bsx);
        stringBuilder3.append(") ");
        z.bsx = stringBuilder3.toString();
        if (paramp.Ft().length > 0) {
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.bsx);
          stringBuilder3.append(" and nStatus in ( ");
          z.bsx = stringBuilder3.toString();
        } 
        for (b1 = 0; b1 < paramp.Ft().length; b1++) {
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.bsx);
          stringBuilder3.append("?,");
          z.bsx = stringBuilder3.toString();
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.dcl);
          stringBuilder3.append(paramp.Ft()[b1]);
          stringBuilder3.append(",");
          z.dcl = stringBuilder3.toString();
        } 
        z.bsx = z.bsx.substring(0, z.bsx.length() - 1);
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(z.bsx);
        stringBuilder3.append(") ");
        z.bsx = stringBuilder3.toString();
        if (paramp.getUserID() != null && Long.parseLong(paramp.getUserID()) > 0L) {
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.bsx);
          stringBuilder3.append(" and nUserID=? ");
          z.bsx = stringBuilder3.toString();
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.dcl);
          stringBuilder3.append(paramp.getUserID());
          stringBuilder3.append(",");
          z.dcl = stringBuilder3.toString();
        } 
        if (paramp.Fu() != null) {
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.bsx);
          stringBuilder3.append(" and (nDateTime between ? and ?) ");
          z.bsx = stringBuilder3.toString();
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.dcl);
          stringBuilder3.append(paramp.Fu()[0]);
          stringBuilder3.append(",");
          z.dcl = stringBuilder3.toString();
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.dcl);
          stringBuilder3.append(paramp.Fu()[1]);
          stringBuilder3.append(",");
          z.dcl = stringBuilder3.toString();
        } 
        if (b < list.size() - 1) {
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.bsx);
          stringBuilder3.append(" union all ");
          z.bsx = stringBuilder3.toString();
        } 
      } 
    } else {
      for (byte b = 0; b < list.size(); b++) {
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(z.bsx);
        stringBuilder3.append("select ");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_accountdoc._id as _id,");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_accountdoc.sSpareField1 as sSpareField1,");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_accountdoc.nUserID as nUserID,");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_accountdoc.nDateTime as nDateTime,");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_accountdoc.sText as sOrderNo,");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_accountdoc.nSpareField1 as nPayType,");
        stringBuilder3.append(1);
        stringBuilder3.append(" nStatus,");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_accountdoc.fAccountAmount as fAmount from ");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_accountdoc where ");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_accountdoc.nShopID=? and ");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_accountdoc.nAccountID in (10007,10009) and ");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_accountdoc.nSpareField1 in ( ");
        z.bsx = stringBuilder3.toString();
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(z.dcl);
        stringBuilder3.append(RootApplication.getLaiqianPreferenceManager().Tx());
        stringBuilder3.append(",");
        z.dcl = stringBuilder3.toString();
        byte b1;
        for (b1 = 0; b1 < paramp.Fs().length; b1++) {
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.bsx);
          stringBuilder3.append("?,");
          z.bsx = stringBuilder3.toString();
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.dcl);
          stringBuilder3.append(paramp.Fs()[b1]);
          stringBuilder3.append(",");
          z.dcl = stringBuilder3.toString();
        } 
        z.bsx = z.bsx.substring(0, z.bsx.length() - 1);
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(z.bsx);
        stringBuilder3.append(") ");
        z.bsx = stringBuilder3.toString();
        if (paramp.getUserID() != null && Long.parseLong(paramp.getUserID()) > 0L) {
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.bsx);
          stringBuilder3.append(" and ");
          stringBuilder3.append((String)list.get(b));
          stringBuilder3.append(".t_accountdoc.nUserID=? ");
          z.bsx = stringBuilder3.toString();
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.dcl);
          stringBuilder3.append(paramp.getUserID());
          stringBuilder3.append(",");
          z.dcl = stringBuilder3.toString();
        } 
        if (paramp.Fu() != null) {
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.bsx);
          stringBuilder3.append(" and (");
          stringBuilder3.append((String)list.get(b));
          stringBuilder3.append(".t_accountdoc.nDateTime between ? and ?) ");
          z.bsx = stringBuilder3.toString();
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.dcl);
          stringBuilder3.append(paramp.Fu()[0]);
          stringBuilder3.append(",");
          z.dcl = stringBuilder3.toString();
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.dcl);
          stringBuilder3.append(paramp.Fu()[1]);
          stringBuilder3.append(",");
          z.dcl = stringBuilder3.toString();
        } 
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(z.bsx);
        stringBuilder3.append("union select ");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc._id as _id,");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.sSpareField1 as sSpareField1,");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.nUserID as nUserID,");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.nDateTime as nDateTime,");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.sOrderNo as sOrderNo,");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.nPayType as nPayType,");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.nStatus as nStatus,");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.fPayAmount as fAmount from ");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc where (");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.nDeletionFlag is null or ");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.nDeletionFlag=0) and ");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.nShopID=? and ");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.nSpareField1=");
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append(" and ");
        stringBuilder3.append((String)list.get(b));
        stringBuilder3.append(".t_temp_productdoc.nPayType in ( ");
        z.bsx = stringBuilder3.toString();
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(z.dcl);
        stringBuilder3.append(RootApplication.getLaiqianPreferenceManager().Tx());
        stringBuilder3.append(",");
        z.dcl = stringBuilder3.toString();
        for (b1 = 0; b1 < paramp.Fs().length; b1++) {
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.bsx);
          stringBuilder3.append("?,");
          z.bsx = stringBuilder3.toString();
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.dcl);
          stringBuilder3.append(paramp.Fs()[b1]);
          stringBuilder3.append(",");
          z.dcl = stringBuilder3.toString();
        } 
        z.bsx = z.bsx.substring(0, z.bsx.length() - 1);
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(z.bsx);
        stringBuilder3.append(") ");
        z.bsx = stringBuilder3.toString();
        if (paramp.Ft().length > 0) {
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.bsx);
          stringBuilder3.append(" and ");
          stringBuilder3.append((String)list.get(b));
          stringBuilder3.append(".t_temp_productdoc.nStatus in ( ");
          z.bsx = stringBuilder3.toString();
        } 
        for (b1 = 0; b1 < paramp.Ft().length; b1++) {
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.bsx);
          stringBuilder3.append("?,");
          z.bsx = stringBuilder3.toString();
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.dcl);
          stringBuilder3.append(paramp.Ft()[b1]);
          stringBuilder3.append(",");
          z.dcl = stringBuilder3.toString();
        } 
        z.bsx = z.bsx.substring(0, z.bsx.length() - 1);
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(z.bsx);
        stringBuilder3.append(") ");
        z.bsx = stringBuilder3.toString();
        if (paramp.getUserID() != null && Long.parseLong(paramp.getUserID()) > 0L) {
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.bsx);
          stringBuilder3.append(" and ");
          stringBuilder3.append((String)list.get(b));
          stringBuilder3.append(".t_temp_productdoc.nUserID=? ");
          z.bsx = stringBuilder3.toString();
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.dcl);
          stringBuilder3.append(paramp.getUserID());
          stringBuilder3.append(",");
          z.dcl = stringBuilder3.toString();
        } 
        if (paramp.Fu() != null) {
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.bsx);
          stringBuilder3.append(" and (");
          stringBuilder3.append((String)list.get(b));
          stringBuilder3.append(".t_temp_productdoc.nDateTime between ? and ?) ");
          z.bsx = stringBuilder3.toString();
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.dcl);
          stringBuilder3.append(paramp.Fu()[0]);
          stringBuilder3.append(",");
          z.dcl = stringBuilder3.toString();
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.dcl);
          stringBuilder3.append(paramp.Fu()[1]);
          stringBuilder3.append(",");
          z.dcl = stringBuilder3.toString();
        } 
        if (b < list.size() - 1) {
          stringBuilder3 = new StringBuilder();
          stringBuilder3.append(z.bsx);
          stringBuilder3.append(" union all ");
          z.bsx = stringBuilder3.toString();
        } 
      } 
    } 
    z.dcl = z.dcl.substring(0, z.dcl.length() - 1);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(z.bsx);
    stringBuilder1.append(") order by nDateTime DESC");
    z.bsx = stringBuilder1.toString();
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(z.dcm);
    stringBuilder1.append("_id,nDateTime,sOrderNo,nPayType,nStatus,fAmount,nUserID,sSpareField1");
    z.dcm = stringBuilder1.toString();
    return z;
  }
  
  public z b(p paramp, String paramString) throws Exception {
    List list = b.g(n.parseLong(paramp.Fu()[0]), n.parseLong(paramp.Fu()[1]));
    z z = new z();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(z.bsx);
    stringBuilder2.append("select _id,nDateTime,sOrderNo,nPayType,nStatus,fAmount,nUserID,sSpareField1,sText,nSpareField2 from(");
    z.bsx = stringBuilder2.toString();
    for (byte b = 0; b < list.size(); b++) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(z.bsx);
      stringBuilder2.append("select ");
      stringBuilder2.append((String)list.get(b));
      stringBuilder2.append(".t_temp_productdoc._id as _id,");
      stringBuilder2.append((String)list.get(b));
      stringBuilder2.append(".t_temp_productdoc.sSpareField1 as sSpareField1,");
      stringBuilder2.append((String)list.get(b));
      stringBuilder2.append(".t_temp_productdoc.nUserID as nUserID,");
      stringBuilder2.append((String)list.get(b));
      stringBuilder2.append(".t_temp_productdoc.nDateTime as nDateTime,");
      stringBuilder2.append((String)list.get(b));
      stringBuilder2.append(".t_temp_productdoc.sOrderNo as sOrderNo,");
      stringBuilder2.append((String)list.get(b));
      stringBuilder2.append(".t_temp_productdoc.nPayType as nPayType,");
      stringBuilder2.append((String)list.get(b));
      stringBuilder2.append(".t_temp_productdoc.nStatus as nStatus,");
      stringBuilder2.append((String)list.get(b));
      stringBuilder2.append(".t_temp_productdoc.fPayAmount as fAmount,");
      stringBuilder2.append((String)list.get(b));
      stringBuilder2.append(".T_TEMP_PRODUCTDOC_STATUS_HISTORY.sText as sText,");
      stringBuilder2.append((String)list.get(b));
      stringBuilder2.append(".t_temp_productdoc.nSpareField2 as nSpareField2 from ");
      stringBuilder2.append((String)list.get(b));
      stringBuilder2.append(".t_temp_productdoc left join ");
      stringBuilder2.append((String)list.get(b));
      stringBuilder2.append(".T_TEMP_PRODUCTDOC_STATUS_HISTORY on ");
      stringBuilder2.append((String)list.get(b));
      stringBuilder2.append(".t_temp_productdoc.sOrderNo = ");
      stringBuilder2.append((String)list.get(b));
      stringBuilder2.append(".T_TEMP_PRODUCTDOC_STATUS_HISTORY.sOrderNo where (");
      stringBuilder2.append((String)list.get(b));
      stringBuilder2.append(".t_temp_productdoc.nDeletionFlag is null or ");
      stringBuilder2.append((String)list.get(b));
      stringBuilder2.append(".t_temp_productdoc.nDeletionFlag=0) and ");
      stringBuilder2.append((String)list.get(b));
      stringBuilder2.append(".t_temp_productdoc.nSpareField1=");
      stringBuilder2.append(paramString);
      stringBuilder2.append(" and ");
      stringBuilder2.append((String)list.get(b));
      stringBuilder2.append(".t_temp_productdoc.nShopID=?  and ");
      stringBuilder2.append((String)list.get(b));
      stringBuilder2.append(".t_temp_productdoc.nPayType in ( ");
      z.bsx = stringBuilder2.toString();
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(z.dcl);
      stringBuilder2.append(RootApplication.getLaiqianPreferenceManager().Tx());
      stringBuilder2.append(",");
      z.dcl = stringBuilder2.toString();
      byte b1;
      for (b1 = 0; b1 < paramp.Fs().length; b1++) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(z.bsx);
        stringBuilder2.append("?,");
        z.bsx = stringBuilder2.toString();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(z.dcl);
        stringBuilder2.append(paramp.Fs()[b1]);
        stringBuilder2.append(",");
        z.dcl = stringBuilder2.toString();
      } 
      z.bsx = z.bsx.substring(0, z.bsx.length() - 1);
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(z.bsx);
      stringBuilder2.append(") ");
      z.bsx = stringBuilder2.toString();
      if (paramp.Ft().length > 0) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(z.bsx);
        stringBuilder2.append(" and ");
        stringBuilder2.append((String)list.get(b));
        stringBuilder2.append(".t_temp_productdoc.nStatus in ( ");
        z.bsx = stringBuilder2.toString();
      } 
      for (b1 = 0; b1 < paramp.Ft().length; b1++) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(z.bsx);
        stringBuilder2.append("?,");
        z.bsx = stringBuilder2.toString();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(z.dcl);
        stringBuilder2.append(paramp.Ft()[b1]);
        stringBuilder2.append(",");
        z.dcl = stringBuilder2.toString();
      } 
      z.bsx = z.bsx.substring(0, z.bsx.length() - 1);
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(z.bsx);
      stringBuilder2.append(") ");
      z.bsx = stringBuilder2.toString();
      if (paramp.getUserID() != null && Long.parseLong(paramp.getUserID()) > 0L) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(z.bsx);
        stringBuilder2.append(" and ");
        stringBuilder2.append((String)list.get(b));
        stringBuilder2.append(".t_temp_productdoc.nUserID=? ");
        z.bsx = stringBuilder2.toString();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(z.dcl);
        stringBuilder2.append(paramp.getUserID());
        stringBuilder2.append(",");
        z.dcl = stringBuilder2.toString();
      } 
      if (paramp.Fu() != null) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(z.bsx);
        stringBuilder2.append(" and (");
        stringBuilder2.append((String)list.get(b));
        stringBuilder2.append(".t_temp_productdoc.nDateTime between ? and ?) ");
        z.bsx = stringBuilder2.toString();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(z.dcl);
        stringBuilder2.append(paramp.Fu()[0]);
        stringBuilder2.append(",");
        z.dcl = stringBuilder2.toString();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(z.dcl);
        stringBuilder2.append(paramp.Fu()[1]);
        stringBuilder2.append(",");
        z.dcl = stringBuilder2.toString();
      } 
      if (b < list.size() - 1) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(z.bsx);
        stringBuilder2.append(" union all ");
        z.bsx = stringBuilder2.toString();
      } 
    } 
    z.dcl = z.dcl.substring(0, z.dcl.length() - 1);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(z.bsx);
    stringBuilder1.append(") order by nDateTime DESC");
    z.bsx = stringBuilder1.toString();
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(z.dcm);
    stringBuilder1.append("_id,nDateTime,sOrderNo,nPayType,nStatus,fAmount,nUserID,sSpareField1,sText,nSpareField2");
    z.dcm = stringBuilder1.toString();
    return z;
  }
  
  public z c(p paramp, String paramString) throws Exception {
    List list = b.g(n.parseLong(paramp.Fu()[0]), n.parseLong(paramp.Fu()[1]));
    z z = new z();
    z.bsx = "select _id,nDateTime,sOrderNo,nPayType,nStatus,fAmount,nUserID,sSpareField1,sOrder,sText from(";
    for (byte b = 0; b < list.size(); b++) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(z.bsx);
      stringBuilder1.append(" select t_temp_productdoc._id as _id,t_temp_productdoc.sSpareField1 as sSpareField1,t_temp_productdoc.nUserID as nUserID,t_temp_productdoc.nDateTime as nDateTime,t_temp_productdoc.sOrderNo as sOrderNo,t_temp_productdoc.nPayType as nPayType,t_temp_productdoc.nStatus as nStatus,t_temp_productdoc.fPayAmount as fAmount ,t_temp_productdoc.sOrder as sOrder ,t_accountdoc.sText sText from ");
      stringBuilder1.append((String)list.get(b));
      stringBuilder1.append(".t_temp_productdoc  left join ");
      stringBuilder1.append((String)list.get(b));
      stringBuilder1.append(".t_accountdoc on t_temp_productdoc.sOrderNo = t_accountdoc.sText  where  (t_temp_productdoc.nDeletionFlag is null or t_temp_productdoc.nDeletionFlag=0) and  t_temp_productdoc.nShopID=? and t_temp_productdoc.nSpareField1 = ");
      stringBuilder1.append(paramString);
      stringBuilder1.append(" and t_temp_productdoc.nPayType in ( ");
      z.bsx = stringBuilder1.toString();
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(z.dcl);
      stringBuilder1.append(RootApplication.getLaiqianPreferenceManager().Tx());
      stringBuilder1.append(",");
      z.dcl = stringBuilder1.toString();
      byte b1;
      for (b1 = 0; b1 < paramp.Fs().length; b1++) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(z.bsx);
        stringBuilder1.append("?,");
        z.bsx = stringBuilder1.toString();
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(z.dcl);
        stringBuilder1.append(paramp.Fs()[b1]);
        stringBuilder1.append(",");
        z.dcl = stringBuilder1.toString();
      } 
      z.bsx = z.bsx.substring(0, z.bsx.length() - 1);
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(z.bsx);
      stringBuilder1.append(") ");
      z.bsx = stringBuilder1.toString();
      if (paramp.Ft().length > 0) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(z.bsx);
        stringBuilder1.append(" and t_temp_productdoc.nStatus in ( ");
        z.bsx = stringBuilder1.toString();
      } 
      for (b1 = 0; b1 < paramp.Ft().length; b1++) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(z.bsx);
        stringBuilder1.append("?,");
        z.bsx = stringBuilder1.toString();
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(z.dcl);
        stringBuilder1.append(paramp.Ft()[b1]);
        stringBuilder1.append(",");
        z.dcl = stringBuilder1.toString();
      } 
      z.bsx = z.bsx.substring(0, z.bsx.length() - 1);
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(z.bsx);
      stringBuilder1.append(") ");
      z.bsx = stringBuilder1.toString();
      if (paramp.getUserID() != null && Long.parseLong(paramp.getUserID()) > 0L) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(z.bsx);
        stringBuilder1.append(" and t_temp_productdoc.nUserID=? ");
        z.bsx = stringBuilder1.toString();
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(z.dcl);
        stringBuilder1.append(paramp.getUserID());
        stringBuilder1.append(",");
        z.dcl = stringBuilder1.toString();
      } 
      if (paramp.Fu() != null) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(z.bsx);
        stringBuilder1.append(" and (t_temp_productdoc.nDateTime between ? and ?) ");
        z.bsx = stringBuilder1.toString();
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(z.dcl);
        stringBuilder1.append(paramp.Fu()[0]);
        stringBuilder1.append(",");
        z.dcl = stringBuilder1.toString();
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(z.dcl);
        stringBuilder1.append(paramp.Fu()[1]);
        stringBuilder1.append(",");
        z.dcl = stringBuilder1.toString();
      } 
      if (b < list.size() - 1) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(z.bsx);
        stringBuilder1.append(" union all ");
        z.bsx = stringBuilder1.toString();
      } 
    } 
    z.dcl = z.dcl.substring(0, z.dcl.length() - 1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(z.bsx);
    stringBuilder.append(") group by sOrderNo ORDER BY nDateTime DESC ");
    z.bsx = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(z.dcm);
    stringBuilder.append("_id,nDateTime,sOrderNo,nPayType,nStatus,fAmount,nUserID,sSpareField1,sOrder,sText");
    z.dcm = stringBuilder.toString();
    return z;
  }
  
  public double[] c(long paramLong1, long paramLong2, long paramLong3) { // Byte code:
    //   0: iconst_3
    //   1: newarray double
    //   3: astore #12
    //   5: aconst_null
    //   6: astore #11
    //   8: aconst_null
    //   9: astore #9
    //   11: aload #9
    //   13: astore #8
    //   15: lload_3
    //   16: lload #5
    //   18: invokestatic g : (JJ)Ljava/util/List;
    //   21: astore #10
    //   23: aload #9
    //   25: astore #8
    //   27: new com/laiqian/db/multidatabase/c/a
    //   30: dup
    //   31: lload_3
    //   32: lload #5
    //   34: invokespecial <init> : (JJ)V
    //   37: invokevirtual getDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   40: astore #13
    //   42: aload #9
    //   44: astore #8
    //   46: new java/lang/StringBuilder
    //   49: dup
    //   50: ldc 'select status,sum(fPayAmount) fPayAmount from ('
    //   52: invokespecial <init> : (Ljava/lang/String;)V
    //   55: astore #14
    //   57: iconst_0
    //   58: istore #7
    //   60: aload #9
    //   62: astore #8
    //   64: iload #7
    //   66: aload #10
    //   68: invokeinterface size : ()I
    //   73: if_icmpge -> 355
    //   76: aload #9
    //   78: astore #8
    //   80: new java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial <init> : ()V
    //   87: astore #15
    //   89: aload #9
    //   91: astore #8
    //   93: aload #15
    //   95: ldc_w 'select (case when nStatus==0 then 0 when nStatus = 1 then 1 else 2 end)  status,sum(fPayAmount) fPayAmount from '
    //   98: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload #9
    //   104: astore #8
    //   106: aload #15
    //   108: aload #10
    //   110: iload #7
    //   112: invokeinterface get : (I)Ljava/lang/Object;
    //   117: checkcast java/lang/String
    //   120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload #9
    //   126: astore #8
    //   128: aload #15
    //   130: ldc_w '.t_temp_productdoc where (nDateTime between '
    //   133: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload #9
    //   139: astore #8
    //   141: aload #15
    //   143: lload_3
    //   144: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload #9
    //   150: astore #8
    //   152: aload #15
    //   154: ldc ' and '
    //   156: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload #9
    //   162: astore #8
    //   164: aload #15
    //   166: lload #5
    //   168: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload #9
    //   174: astore #8
    //   176: aload #15
    //   178: ldc_w ')'
    //   181: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload #9
    //   187: astore #8
    //   189: aload #14
    //   191: aload #15
    //   193: invokevirtual toString : ()Ljava/lang/String;
    //   196: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload #9
    //   202: astore #8
    //   204: new java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial <init> : ()V
    //   211: astore #15
    //   213: aload #9
    //   215: astore #8
    //   217: aload #15
    //   219: ldc_w ' and nUserID='
    //   222: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload #9
    //   228: astore #8
    //   230: aload #15
    //   232: lload_1
    //   233: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload #9
    //   239: astore #8
    //   241: aload #14
    //   243: aload #15
    //   245: invokevirtual toString : ()Ljava/lang/String;
    //   248: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload #9
    //   254: astore #8
    //   256: new java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial <init> : ()V
    //   263: astore #15
    //   265: aload #9
    //   267: astore #8
    //   269: aload #15
    //   271: ldc_w ' and (nDeletionFlag is null or nDeletionFlag=0) and nSpareField2 = 1 and nSpareField1=1 and nShopID= '
    //   274: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload #9
    //   280: astore #8
    //   282: aload #15
    //   284: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   287: invokevirtual Tx : ()Ljava/lang/String;
    //   290: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload #9
    //   296: astore #8
    //   298: aload #14
    //   300: aload #15
    //   302: invokevirtual toString : ()Ljava/lang/String;
    //   305: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload #9
    //   311: astore #8
    //   313: aload #14
    //   315: ldc_w ' group by status'
    //   318: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload #9
    //   324: astore #8
    //   326: iload #7
    //   328: aload #10
    //   330: invokeinterface size : ()I
    //   335: iconst_1
    //   336: isub
    //   337: if_icmpge -> 518
    //   340: aload #9
    //   342: astore #8
    //   344: aload #14
    //   346: ldc ' union all '
    //   348: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: goto -> 518
    //   355: aload #9
    //   357: astore #8
    //   359: aload #14
    //   361: ldc_w ') group by status '
    //   364: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload #9
    //   370: astore #8
    //   372: aload #13
    //   374: aload #14
    //   376: invokevirtual toString : ()Ljava/lang/String;
    //   379: aconst_null
    //   380: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   383: astore #9
    //   385: aload #9
    //   387: invokeinterface moveToNext : ()Z
    //   392: ifeq -> 435
    //   395: aload #12
    //   397: aload #9
    //   399: aload #9
    //   401: ldc_w 'status'
    //   404: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   409: invokeinterface getInt : (I)I
    //   414: aload #9
    //   416: aload #9
    //   418: ldc_w 'fPayAmount'
    //   421: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   426: invokeinterface getDouble : (I)D
    //   431: dastore
    //   432: goto -> 385
    //   435: aload #9
    //   437: ifnull -> 500
    //   440: aload #9
    //   442: invokeinterface close : ()V
    //   447: aload #12
    //   449: areturn
    //   450: astore #10
    //   452: aload #9
    //   454: astore #8
    //   456: aload #10
    //   458: astore #9
    //   460: goto -> 503
    //   463: astore #10
    //   465: goto -> 479
    //   468: astore #9
    //   470: goto -> 503
    //   473: astore #10
    //   475: aload #11
    //   477: astore #9
    //   479: aload #9
    //   481: astore #8
    //   483: aload #10
    //   485: invokestatic e : (Ljava/lang/Throwable;)V
    //   488: aload #9
    //   490: ifnull -> 500
    //   493: aload #9
    //   495: invokeinterface close : ()V
    //   500: aload #12
    //   502: areturn
    //   503: aload #8
    //   505: ifnull -> 515
    //   508: aload #8
    //   510: invokeinterface close : ()V
    //   515: aload #9
    //   517: athrow
    //   518: iload #7
    //   520: iconst_1
    //   521: iadd
    //   522: istore #7
    //   524: goto -> 60
    // Exception table:
    //   from	to	target	type
    //   15	23	473	java/lang/Exception
    //   15	23	468	finally
    //   27	42	473	java/lang/Exception
    //   27	42	468	finally
    //   46	57	473	java/lang/Exception
    //   46	57	468	finally
    //   64	76	473	java/lang/Exception
    //   64	76	468	finally
    //   80	89	473	java/lang/Exception
    //   80	89	468	finally
    //   93	102	473	java/lang/Exception
    //   93	102	468	finally
    //   106	124	473	java/lang/Exception
    //   106	124	468	finally
    //   128	137	473	java/lang/Exception
    //   128	137	468	finally
    //   141	148	473	java/lang/Exception
    //   141	148	468	finally
    //   152	160	473	java/lang/Exception
    //   152	160	468	finally
    //   164	172	473	java/lang/Exception
    //   164	172	468	finally
    //   176	185	473	java/lang/Exception
    //   176	185	468	finally
    //   189	200	473	java/lang/Exception
    //   189	200	468	finally
    //   204	213	473	java/lang/Exception
    //   204	213	468	finally
    //   217	226	473	java/lang/Exception
    //   217	226	468	finally
    //   230	237	473	java/lang/Exception
    //   230	237	468	finally
    //   241	252	473	java/lang/Exception
    //   241	252	468	finally
    //   256	265	473	java/lang/Exception
    //   256	265	468	finally
    //   269	278	473	java/lang/Exception
    //   269	278	468	finally
    //   282	294	473	java/lang/Exception
    //   282	294	468	finally
    //   298	309	473	java/lang/Exception
    //   298	309	468	finally
    //   313	322	473	java/lang/Exception
    //   313	322	468	finally
    //   326	340	473	java/lang/Exception
    //   326	340	468	finally
    //   344	352	473	java/lang/Exception
    //   344	352	468	finally
    //   359	368	473	java/lang/Exception
    //   359	368	468	finally
    //   372	385	473	java/lang/Exception
    //   372	385	468	finally
    //   385	432	463	java/lang/Exception
    //   385	432	450	finally
    //   483	488	468	finally }
  
  public String e(String paramString, long paramLong) {
    str2 = "";
    hashMap = new HashMap();
    hashMap.put("out_trade_no", paramString);
    null = new av(RootApplication.zv());
    hashMap.put("shop_id", null.Tx());
    hashMap.put("pay_type", "bar_code");
    null.close();
    hashMap.put("business_type", "reception");
    str1 = "";
    if (paramLong == 1L || paramLong == 0L) {
      str1 = a.cqJ;
    } else if (paramLong == 5L || paramLong == 8L) {
      str1 = a.cqN;
    } 
    k k = new k();
    str3 = str2;
    try {
      str1 = k.b(hashMap, str1, 1);
    } catch (Exception hashMap) {
      str1 = str2;
      str3 = str1;
      return str1;
    } finally {
      str1 = null;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */