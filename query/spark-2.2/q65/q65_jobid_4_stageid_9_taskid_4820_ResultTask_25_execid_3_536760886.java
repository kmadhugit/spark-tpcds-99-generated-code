/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificSafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificSafeProjection extends org.apache.spark.sql.catalyst.expressions.codegen.BaseProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private InternalRow mutableRow;
/* 009 */   private Object[] values;
/* 010 */   private org.apache.spark.sql.types.StructType schema;
/* 011 */
/* 012 */   public SpecificSafeProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     mutableRow = (InternalRow) references[references.length - 1];
/* 015 */
/* 016 */     this.schema = (org.apache.spark.sql.types.StructType) references[0];
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */   private void apply_1(InternalRow i) {
/* 026 */
/* 027 */     boolean isNull5 = i.isNullAt(2);
/* 028 */     double value5 = isNull5 ? -1.0 : (i.getDouble(2));
/* 029 */     if (isNull5) {
/* 030 */       values[2] = null;
/* 031 */     } else {
/* 032 */       values[2] = value5;
/* 033 */     }
/* 034 */
/* 035 */     boolean isNull6 = i.isNullAt(3);
/* 036 */     double value6 = isNull6 ? -1.0 : (i.getDouble(3));
/* 037 */     if (isNull6) {
/* 038 */       values[3] = null;
/* 039 */     } else {
/* 040 */       values[3] = value6;
/* 041 */     }
/* 042 */
/* 043 */     boolean isNull7 = i.isNullAt(4);
/* 044 */     double value7 = isNull7 ? -1.0 : (i.getDouble(4));
/* 045 */     if (isNull7) {
/* 046 */       values[4] = null;
/* 047 */     } else {
/* 048 */       values[4] = value7;
/* 049 */     }
/* 050 */
/* 051 */     boolean isNull9 = i.isNullAt(5);
/* 052 */     UTF8String value9 = isNull9 ? null : (i.getUTF8String(5));
/* 053 */     boolean isNull8 = true;
/* 054 */     java.lang.String value8 = null;
/* 055 */     if (!isNull9) {
/* 056 */
/* 057 */       isNull8 = false;
/* 058 */       if (!isNull8) {
/* 059 */
/* 060 */         Object funcResult2 = null;
/* 061 */         funcResult2 = value9.toString();
/* 062 */         value8 = (java.lang.String) funcResult2;
/* 063 */
/* 064 */       }
/* 065 */     }
/* 066 */     if (isNull8) {
/* 067 */       values[5] = null;
/* 068 */     } else {
/* 069 */       values[5] = value8;
/* 070 */     }
/* 071 */
/* 072 */   }
/* 073 */
/* 074 */
/* 075 */   private void apply_0(InternalRow i) {
/* 076 */
/* 077 */     boolean isNull2 = i.isNullAt(0);
/* 078 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 079 */     boolean isNull1 = true;
/* 080 */     java.lang.String value1 = null;
/* 081 */     if (!isNull2) {
/* 082 */
/* 083 */       isNull1 = false;
/* 084 */       if (!isNull1) {
/* 085 */
/* 086 */         Object funcResult = null;
/* 087 */         funcResult = value2.toString();
/* 088 */         value1 = (java.lang.String) funcResult;
/* 089 */
/* 090 */       }
/* 091 */     }
/* 092 */     if (isNull1) {
/* 093 */       values[0] = null;
/* 094 */     } else {
/* 095 */       values[0] = value1;
/* 096 */     }
/* 097 */
/* 098 */     boolean isNull4 = i.isNullAt(1);
/* 099 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 100 */     boolean isNull3 = true;
/* 101 */     java.lang.String value3 = null;
/* 102 */     if (!isNull4) {
/* 103 */
/* 104 */       isNull3 = false;
/* 105 */       if (!isNull3) {
/* 106 */
/* 107 */         Object funcResult1 = null;
/* 108 */         funcResult1 = value4.toString();
/* 109 */         value3 = (java.lang.String) funcResult1;
/* 110 */
/* 111 */       }
/* 112 */     }
/* 113 */     if (isNull3) {
/* 114 */       values[1] = null;
/* 115 */     } else {
/* 116 */       values[1] = value3;
/* 117 */     }
/* 118 */
/* 119 */   }
/* 120 */
/* 121 */
/* 122 */   public java.lang.Object apply(java.lang.Object _i) {
/* 123 */     InternalRow i = (InternalRow) _i;
/* 124 */
/* 125 */     values = new Object[6];
/* 126 */     apply_0(i);
/* 127 */     apply_1(i);
/* 128 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 129 */     if (false) {
/* 130 */       mutableRow.setNullAt(0);
/* 131 */     } else {
/* 132 */
/* 133 */       mutableRow.update(0, value);
/* 134 */     }
/* 135 */
/* 136 */     return mutableRow;
/* 137 */   }
/* 138 */ }
