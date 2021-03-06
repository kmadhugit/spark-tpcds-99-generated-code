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
/* 025 */
/* 026 */   public java.lang.Object apply(java.lang.Object _i) {
/* 027 */     InternalRow i = (InternalRow) _i;
/* 028 */
/* 029 */     values = new Object[4];
/* 030 */
/* 031 */     boolean isNull2 = i.isNullAt(0);
/* 032 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 033 */     boolean isNull1 = true;
/* 034 */     java.lang.String value1 = null;
/* 035 */     if (!isNull2) {
/* 036 */
/* 037 */       isNull1 = false;
/* 038 */       if (!isNull1) {
/* 039 */
/* 040 */         Object funcResult = null;
/* 041 */         funcResult = value2.toString();
/* 042 */         value1 = (java.lang.String) funcResult;
/* 043 */
/* 044 */       }
/* 045 */     }
/* 046 */     if (isNull1) {
/* 047 */       values[0] = null;
/* 048 */     } else {
/* 049 */       values[0] = value1;
/* 050 */     }
/* 051 */
/* 052 */     boolean isNull3 = i.isNullAt(1);
/* 053 */     double value3 = isNull3 ? -1.0 : (i.getDouble(1));
/* 054 */     if (isNull3) {
/* 055 */       values[1] = null;
/* 056 */     } else {
/* 057 */       values[1] = value3;
/* 058 */     }
/* 059 */
/* 060 */     boolean isNull4 = i.isNullAt(2);
/* 061 */     double value4 = isNull4 ? -1.0 : (i.getDouble(2));
/* 062 */     if (isNull4) {
/* 063 */       values[2] = null;
/* 064 */     } else {
/* 065 */       values[2] = value4;
/* 066 */     }
/* 067 */
/* 068 */     boolean isNull5 = i.isNullAt(3);
/* 069 */     double value5 = isNull5 ? -1.0 : (i.getDouble(3));
/* 070 */     if (isNull5) {
/* 071 */       values[3] = null;
/* 072 */     } else {
/* 073 */       values[3] = value5;
/* 074 */     }
/* 075 */
/* 076 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 077 */     if (false) {
/* 078 */       mutableRow.setNullAt(0);
/* 079 */     } else {
/* 080 */
/* 081 */       mutableRow.update(0, value);
/* 082 */     }
/* 083 */
/* 084 */     return mutableRow;
/* 085 */   }
/* 086 */ }
