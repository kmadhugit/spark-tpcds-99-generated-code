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
/* 051 */   }
/* 052 */
/* 053 */
/* 054 */   private void apply_0(InternalRow i) {
/* 055 */
/* 056 */     boolean isNull2 = i.isNullAt(0);
/* 057 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 058 */     boolean isNull1 = true;
/* 059 */     java.lang.String value1 = null;
/* 060 */     if (!isNull2) {
/* 061 */
/* 062 */       isNull1 = false;
/* 063 */       if (!isNull1) {
/* 064 */
/* 065 */         Object funcResult = null;
/* 066 */         funcResult = value2.toString();
/* 067 */         value1 = (java.lang.String) funcResult;
/* 068 */
/* 069 */       }
/* 070 */     }
/* 071 */     if (isNull1) {
/* 072 */       values[0] = null;
/* 073 */     } else {
/* 074 */       values[0] = value1;
/* 075 */     }
/* 076 */
/* 077 */     boolean isNull4 = i.isNullAt(1);
/* 078 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 079 */     boolean isNull3 = true;
/* 080 */     java.lang.String value3 = null;
/* 081 */     if (!isNull4) {
/* 082 */
/* 083 */       isNull3 = false;
/* 084 */       if (!isNull3) {
/* 085 */
/* 086 */         Object funcResult1 = null;
/* 087 */         funcResult1 = value4.toString();
/* 088 */         value3 = (java.lang.String) funcResult1;
/* 089 */
/* 090 */       }
/* 091 */     }
/* 092 */     if (isNull3) {
/* 093 */       values[1] = null;
/* 094 */     } else {
/* 095 */       values[1] = value3;
/* 096 */     }
/* 097 */
/* 098 */   }
/* 099 */
/* 100 */
/* 101 */   public java.lang.Object apply(java.lang.Object _i) {
/* 102 */     InternalRow i = (InternalRow) _i;
/* 103 */
/* 104 */     values = new Object[5];
/* 105 */     apply_0(i);
/* 106 */     apply_1(i);
/* 107 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 108 */     if (false) {
/* 109 */       mutableRow.setNullAt(0);
/* 110 */     } else {
/* 111 */
/* 112 */       mutableRow.update(0, value);
/* 113 */     }
/* 114 */
/* 115 */     return mutableRow;
/* 116 */   }
/* 117 */ }
