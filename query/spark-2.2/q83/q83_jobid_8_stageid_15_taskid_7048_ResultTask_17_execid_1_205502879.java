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
/* 027 */     boolean isNull6 = i.isNullAt(4);
/* 028 */     double value6 = isNull6 ? -1.0 : (i.getDouble(4));
/* 029 */     if (isNull6) {
/* 030 */       values[4] = null;
/* 031 */     } else {
/* 032 */       values[4] = value6;
/* 033 */     }
/* 034 */
/* 035 */     boolean isNull7 = i.isNullAt(5);
/* 036 */     long value7 = isNull7 ? -1L : (i.getLong(5));
/* 037 */     if (isNull7) {
/* 038 */       values[5] = null;
/* 039 */     } else {
/* 040 */       values[5] = value7;
/* 041 */     }
/* 042 */
/* 043 */     boolean isNull8 = i.isNullAt(6);
/* 044 */     double value8 = isNull8 ? -1.0 : (i.getDouble(6));
/* 045 */     if (isNull8) {
/* 046 */       values[6] = null;
/* 047 */     } else {
/* 048 */       values[6] = value8;
/* 049 */     }
/* 050 */
/* 051 */     boolean isNull10 = i.isNullAt(7);
/* 052 */     Decimal value10 = isNull10 ? null : (i.getDecimal(7, 27, 6));
/* 053 */     boolean isNull9 = true;
/* 054 */     java.math.BigDecimal value9 = null;
/* 055 */     if (!isNull10) {
/* 056 */
/* 057 */       isNull9 = false;
/* 058 */       if (!isNull9) {
/* 059 */
/* 060 */         Object funcResult1 = null;
/* 061 */         funcResult1 = value10.toJavaBigDecimal();
/* 062 */         value9 = (java.math.BigDecimal) funcResult1;
/* 063 */
/* 064 */       }
/* 065 */     }
/* 066 */     if (isNull9) {
/* 067 */       values[7] = null;
/* 068 */     } else {
/* 069 */       values[7] = value9;
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
/* 098 */     boolean isNull3 = i.isNullAt(1);
/* 099 */     long value3 = isNull3 ? -1L : (i.getLong(1));
/* 100 */     if (isNull3) {
/* 101 */       values[1] = null;
/* 102 */     } else {
/* 103 */       values[1] = value3;
/* 104 */     }
/* 105 */
/* 106 */     boolean isNull4 = i.isNullAt(2);
/* 107 */     double value4 = isNull4 ? -1.0 : (i.getDouble(2));
/* 108 */     if (isNull4) {
/* 109 */       values[2] = null;
/* 110 */     } else {
/* 111 */       values[2] = value4;
/* 112 */     }
/* 113 */
/* 114 */     boolean isNull5 = i.isNullAt(3);
/* 115 */     long value5 = isNull5 ? -1L : (i.getLong(3));
/* 116 */     if (isNull5) {
/* 117 */       values[3] = null;
/* 118 */     } else {
/* 119 */       values[3] = value5;
/* 120 */     }
/* 121 */
/* 122 */   }
/* 123 */
/* 124 */
/* 125 */   public java.lang.Object apply(java.lang.Object _i) {
/* 126 */     InternalRow i = (InternalRow) _i;
/* 127 */
/* 128 */     values = new Object[8];
/* 129 */     apply_0(i);
/* 130 */     apply_1(i);
/* 131 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 132 */     if (false) {
/* 133 */       mutableRow.setNullAt(0);
/* 134 */     } else {
/* 135 */
/* 136 */       mutableRow.update(0, value);
/* 137 */     }
/* 138 */
/* 139 */     return mutableRow;
/* 140 */   }
/* 141 */ }
