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
/* 035 */   }
/* 036 */
/* 037 */
/* 038 */   private void apply_0(InternalRow i) {
/* 039 */
/* 040 */     boolean isNull2 = i.isNullAt(0);
/* 041 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 042 */     boolean isNull1 = true;
/* 043 */     java.lang.String value1 = null;
/* 044 */     if (!isNull2) {
/* 045 */
/* 046 */       isNull1 = false;
/* 047 */       if (!isNull1) {
/* 048 */
/* 049 */         Object funcResult = null;
/* 050 */         funcResult = value2.toString();
/* 051 */         value1 = (java.lang.String) funcResult;
/* 052 */
/* 053 */       }
/* 054 */     }
/* 055 */     if (isNull1) {
/* 056 */       values[0] = null;
/* 057 */     } else {
/* 058 */       values[0] = value1;
/* 059 */     }
/* 060 */
/* 061 */     boolean isNull3 = i.isNullAt(1);
/* 062 */     double value3 = isNull3 ? -1.0 : (i.getDouble(1));
/* 063 */     if (isNull3) {
/* 064 */       values[1] = null;
/* 065 */     } else {
/* 066 */       values[1] = value3;
/* 067 */     }
/* 068 */
/* 069 */     boolean isNull4 = i.isNullAt(2);
/* 070 */     double value4 = isNull4 ? -1.0 : (i.getDouble(2));
/* 071 */     if (isNull4) {
/* 072 */       values[2] = null;
/* 073 */     } else {
/* 074 */       values[2] = value4;
/* 075 */     }
/* 076 */
/* 077 */     boolean isNull5 = i.isNullAt(3);
/* 078 */     double value5 = isNull5 ? -1.0 : (i.getDouble(3));
/* 079 */     if (isNull5) {
/* 080 */       values[3] = null;
/* 081 */     } else {
/* 082 */       values[3] = value5;
/* 083 */     }
/* 084 */
/* 085 */   }
/* 086 */
/* 087 */
/* 088 */   public java.lang.Object apply(java.lang.Object _i) {
/* 089 */     InternalRow i = (InternalRow) _i;
/* 090 */
/* 091 */     values = new Object[5];
/* 092 */     apply_0(i);
/* 093 */     apply_1(i);
/* 094 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 095 */     if (false) {
/* 096 */       mutableRow.setNullAt(0);
/* 097 */     } else {
/* 098 */
/* 099 */       mutableRow.update(0, value);
/* 100 */     }
/* 101 */
/* 102 */     return mutableRow;
/* 103 */   }
/* 104 */ }
