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
/* 029 */     values = new Object[3];
/* 030 */
/* 031 */     boolean isNull1 = i.isNullAt(0);
/* 032 */     int value1 = isNull1 ? -1 : (i.getInt(0));
/* 033 */     if (isNull1) {
/* 034 */       values[0] = null;
/* 035 */     } else {
/* 036 */       values[0] = value1;
/* 037 */     }
/* 038 */
/* 039 */     boolean isNull3 = i.isNullAt(1);
/* 040 */     UTF8String value3 = isNull3 ? null : (i.getUTF8String(1));
/* 041 */     boolean isNull2 = true;
/* 042 */     java.lang.String value2 = null;
/* 043 */     if (!isNull3) {
/* 044 */
/* 045 */       isNull2 = false;
/* 046 */       if (!isNull2) {
/* 047 */
/* 048 */         Object funcResult = null;
/* 049 */         funcResult = value3.toString();
/* 050 */         value2 = (java.lang.String) funcResult;
/* 051 */
/* 052 */       }
/* 053 */     }
/* 054 */     if (isNull2) {
/* 055 */       values[1] = null;
/* 056 */     } else {
/* 057 */       values[1] = value2;
/* 058 */     }
/* 059 */
/* 060 */     boolean isNull5 = i.isNullAt(2);
/* 061 */     UTF8String value5 = isNull5 ? null : (i.getUTF8String(2));
/* 062 */     boolean isNull4 = true;
/* 063 */     java.lang.String value4 = null;
/* 064 */     if (!isNull5) {
/* 065 */
/* 066 */       isNull4 = false;
/* 067 */       if (!isNull4) {
/* 068 */
/* 069 */         Object funcResult1 = null;
/* 070 */         funcResult1 = value5.toString();
/* 071 */         value4 = (java.lang.String) funcResult1;
/* 072 */
/* 073 */       }
/* 074 */     }
/* 075 */     if (isNull4) {
/* 076 */       values[2] = null;
/* 077 */     } else {
/* 078 */       values[2] = value4;
/* 079 */     }
/* 080 */
/* 081 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 082 */     if (false) {
/* 083 */       mutableRow.setNullAt(0);
/* 084 */     } else {
/* 085 */
/* 086 */       mutableRow.update(0, value);
/* 087 */     }
/* 088 */
/* 089 */     return mutableRow;
/* 090 */   }
/* 091 */ }
