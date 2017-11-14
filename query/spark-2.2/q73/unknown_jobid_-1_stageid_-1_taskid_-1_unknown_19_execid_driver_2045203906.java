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
/* 029 */     values = new Object[2];
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
/* 052 */     boolean isNull4 = i.isNullAt(1);
/* 053 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 054 */     boolean isNull3 = true;
/* 055 */     java.lang.String value3 = null;
/* 056 */     if (!isNull4) {
/* 057 */
/* 058 */       isNull3 = false;
/* 059 */       if (!isNull3) {
/* 060 */
/* 061 */         Object funcResult1 = null;
/* 062 */         funcResult1 = value4.toString();
/* 063 */         value3 = (java.lang.String) funcResult1;
/* 064 */
/* 065 */       }
/* 066 */     }
/* 067 */     if (isNull3) {
/* 068 */       values[1] = null;
/* 069 */     } else {
/* 070 */       values[1] = value3;
/* 071 */     }
/* 072 */
/* 073 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 074 */     if (false) {
/* 075 */       mutableRow.setNullAt(0);
/* 076 */     } else {
/* 077 */
/* 078 */       mutableRow.update(0, value);
/* 079 */     }
/* 080 */
/* 081 */     return mutableRow;
/* 082 */   }
/* 083 */ }
