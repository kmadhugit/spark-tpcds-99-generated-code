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
/* 027 */     boolean isNull6 = i.isNullAt(3);
/* 028 */     int value6 = isNull6 ? -1 : (i.getInt(3));
/* 029 */     if (isNull6) {
/* 030 */       values[3] = null;
/* 031 */     } else {
/* 032 */       values[3] = value6;
/* 033 */     }
/* 034 */
/* 035 */     boolean isNull7 = i.isNullAt(4);
/* 036 */     int value7 = isNull7 ? -1 : (i.getInt(4));
/* 037 */     if (isNull7) {
/* 038 */       values[4] = null;
/* 039 */     } else {
/* 040 */       values[4] = value7;
/* 041 */     }
/* 042 */
/* 043 */   }
/* 044 */
/* 045 */
/* 046 */   private void apply_0(InternalRow i) {
/* 047 */
/* 048 */     UTF8String value2 = i.getUTF8String(0);
/* 049 */     boolean isNull1 = true;
/* 050 */     java.lang.String value1 = null;
/* 051 */     if (!false) {
/* 052 */
/* 053 */       isNull1 = false;
/* 054 */       if (!isNull1) {
/* 055 */
/* 056 */         Object funcResult = null;
/* 057 */         funcResult = value2.toString();
/* 058 */         value1 = (java.lang.String) funcResult;
/* 059 */
/* 060 */       }
/* 061 */     }
/* 062 */     if (isNull1) {
/* 063 */       values[0] = null;
/* 064 */     } else {
/* 065 */       values[0] = value1;
/* 066 */     }
/* 067 */
/* 068 */     boolean isNull3 = i.isNullAt(1);
/* 069 */     int value3 = isNull3 ? -1 : (i.getInt(1));
/* 070 */     if (isNull3) {
/* 071 */       values[1] = null;
/* 072 */     } else {
/* 073 */       values[1] = value3;
/* 074 */     }
/* 075 */
/* 076 */     boolean isNull5 = i.isNullAt(2);
/* 077 */     Decimal value5 = isNull5 ? null : (i.getDecimal(2, 35, 20));
/* 078 */     boolean isNull4 = true;
/* 079 */     java.math.BigDecimal value4 = null;
/* 080 */     if (!isNull5) {
/* 081 */
/* 082 */       isNull4 = false;
/* 083 */       if (!isNull4) {
/* 084 */
/* 085 */         Object funcResult1 = null;
/* 086 */         funcResult1 = value5.toJavaBigDecimal();
/* 087 */         value4 = (java.math.BigDecimal) funcResult1;
/* 088 */
/* 089 */       }
/* 090 */     }
/* 091 */     if (isNull4) {
/* 092 */       values[2] = null;
/* 093 */     } else {
/* 094 */       values[2] = value4;
/* 095 */     }
/* 096 */
/* 097 */   }
/* 098 */
/* 099 */
/* 100 */   public java.lang.Object apply(java.lang.Object _i) {
/* 101 */     InternalRow i = (InternalRow) _i;
/* 102 */
/* 103 */     values = new Object[5];
/* 104 */     apply_0(i);
/* 105 */     apply_1(i);
/* 106 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 107 */     if (false) {
/* 108 */       mutableRow.setNullAt(0);
/* 109 */     } else {
/* 110 */
/* 111 */       mutableRow.update(0, value);
/* 112 */     }
/* 113 */
/* 114 */     return mutableRow;
/* 115 */   }
/* 116 */ }
