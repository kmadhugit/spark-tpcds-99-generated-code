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
/* 028 */     long value5 = isNull5 ? -1L : (i.getLong(2));
/* 029 */     if (isNull5) {
/* 030 */       values[2] = null;
/* 031 */     } else {
/* 032 */       values[2] = value5;
/* 033 */     }
/* 034 */
/* 035 */     boolean isNull6 = i.isNullAt(3);
/* 036 */     long value6 = isNull6 ? -1L : (i.getLong(3));
/* 037 */     if (isNull6) {
/* 038 */       values[3] = null;
/* 039 */     } else {
/* 040 */       values[3] = value6;
/* 041 */     }
/* 042 */
/* 043 */   }
/* 044 */
/* 045 */
/* 046 */   private void apply_0(InternalRow i) {
/* 047 */
/* 048 */     boolean isNull2 = i.isNullAt(0);
/* 049 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 050 */     boolean isNull1 = true;
/* 051 */     java.lang.String value1 = null;
/* 052 */     if (!isNull2) {
/* 053 */
/* 054 */       isNull1 = false;
/* 055 */       if (!isNull1) {
/* 056 */
/* 057 */         Object funcResult = null;
/* 058 */         funcResult = value2.toString();
/* 059 */         value1 = (java.lang.String) funcResult;
/* 060 */
/* 061 */       }
/* 062 */     }
/* 063 */     if (isNull1) {
/* 064 */       values[0] = null;
/* 065 */     } else {
/* 066 */       values[0] = value1;
/* 067 */     }
/* 068 */
/* 069 */     boolean isNull4 = i.isNullAt(1);
/* 070 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 071 */     boolean isNull3 = true;
/* 072 */     java.lang.String value3 = null;
/* 073 */     if (!isNull4) {
/* 074 */
/* 075 */       isNull3 = false;
/* 076 */       if (!isNull3) {
/* 077 */
/* 078 */         Object funcResult1 = null;
/* 079 */         funcResult1 = value4.toString();
/* 080 */         value3 = (java.lang.String) funcResult1;
/* 081 */
/* 082 */       }
/* 083 */     }
/* 084 */     if (isNull3) {
/* 085 */       values[1] = null;
/* 086 */     } else {
/* 087 */       values[1] = value3;
/* 088 */     }
/* 089 */
/* 090 */   }
/* 091 */
/* 092 */
/* 093 */   public java.lang.Object apply(java.lang.Object _i) {
/* 094 */     InternalRow i = (InternalRow) _i;
/* 095 */
/* 096 */     values = new Object[4];
/* 097 */     apply_0(i);
/* 098 */     apply_1(i);
/* 099 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 100 */     if (false) {
/* 101 */       mutableRow.setNullAt(0);
/* 102 */     } else {
/* 103 */
/* 104 */       mutableRow.update(0, value);
/* 105 */     }
/* 106 */
/* 107 */     return mutableRow;
/* 108 */   }
/* 109 */ }
