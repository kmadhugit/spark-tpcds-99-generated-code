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
/* 027 */     boolean isNull7 = i.isNullAt(4);
/* 028 */     double value7 = isNull7 ? -1.0 : (i.getDouble(4));
/* 029 */     if (isNull7) {
/* 030 */       values[4] = null;
/* 031 */     } else {
/* 032 */       values[4] = value7;
/* 033 */     }
/* 034 */
/* 035 */   }
/* 036 */
/* 037 */
/* 038 */   private void apply_0(InternalRow i) {
/* 039 */
/* 040 */     boolean isNull1 = i.isNullAt(0);
/* 041 */     int value1 = isNull1 ? -1 : (i.getInt(0));
/* 042 */     if (isNull1) {
/* 043 */       values[0] = null;
/* 044 */     } else {
/* 045 */       values[0] = value1;
/* 046 */     }
/* 047 */
/* 048 */     boolean isNull3 = i.isNullAt(1);
/* 049 */     UTF8String value3 = isNull3 ? null : (i.getUTF8String(1));
/* 050 */     boolean isNull2 = true;
/* 051 */     java.lang.String value2 = null;
/* 052 */     if (!isNull3) {
/* 053 */
/* 054 */       isNull2 = false;
/* 055 */       if (!isNull2) {
/* 056 */
/* 057 */         Object funcResult = null;
/* 058 */         funcResult = value3.toString();
/* 059 */         value2 = (java.lang.String) funcResult;
/* 060 */
/* 061 */       }
/* 062 */     }
/* 063 */     if (isNull2) {
/* 064 */       values[1] = null;
/* 065 */     } else {
/* 066 */       values[1] = value2;
/* 067 */     }
/* 068 */
/* 069 */     boolean isNull4 = i.isNullAt(2);
/* 070 */     int value4 = isNull4 ? -1 : (i.getInt(2));
/* 071 */     if (isNull4) {
/* 072 */       values[2] = null;
/* 073 */     } else {
/* 074 */       values[2] = value4;
/* 075 */     }
/* 076 */
/* 077 */     boolean isNull6 = i.isNullAt(3);
/* 078 */     UTF8String value6 = isNull6 ? null : (i.getUTF8String(3));
/* 079 */     boolean isNull5 = true;
/* 080 */     java.lang.String value5 = null;
/* 081 */     if (!isNull6) {
/* 082 */
/* 083 */       isNull5 = false;
/* 084 */       if (!isNull5) {
/* 085 */
/* 086 */         Object funcResult1 = null;
/* 087 */         funcResult1 = value6.toString();
/* 088 */         value5 = (java.lang.String) funcResult1;
/* 089 */
/* 090 */       }
/* 091 */     }
/* 092 */     if (isNull5) {
/* 093 */       values[3] = null;
/* 094 */     } else {
/* 095 */       values[3] = value5;
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
