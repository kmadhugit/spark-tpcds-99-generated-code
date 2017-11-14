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
/* 061 */     boolean isNull4 = i.isNullAt(1);
/* 062 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 063 */     boolean isNull3 = true;
/* 064 */     java.lang.String value3 = null;
/* 065 */     if (!isNull4) {
/* 066 */
/* 067 */       isNull3 = false;
/* 068 */       if (!isNull3) {
/* 069 */
/* 070 */         Object funcResult1 = null;
/* 071 */         funcResult1 = value4.toString();
/* 072 */         value3 = (java.lang.String) funcResult1;
/* 073 */
/* 074 */       }
/* 075 */     }
/* 076 */     if (isNull3) {
/* 077 */       values[1] = null;
/* 078 */     } else {
/* 079 */       values[1] = value3;
/* 080 */     }
/* 081 */
/* 082 */   }
/* 083 */
/* 084 */
/* 085 */   public java.lang.Object apply(java.lang.Object _i) {
/* 086 */     InternalRow i = (InternalRow) _i;
/* 087 */
/* 088 */     values = new Object[3];
/* 089 */     apply_0(i);
/* 090 */     apply_1(i);
/* 091 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 092 */     if (false) {
/* 093 */       mutableRow.setNullAt(0);
/* 094 */     } else {
/* 095 */
/* 096 */       mutableRow.update(0, value);
/* 097 */     }
/* 098 */
/* 099 */     return mutableRow;
/* 100 */   }
/* 101 */ }
