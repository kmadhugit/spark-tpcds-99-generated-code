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
/* 027 */     boolean isNull6 = i.isNullAt(2);
/* 028 */     UTF8String value6 = isNull6 ? null : (i.getUTF8String(2));
/* 029 */     boolean isNull5 = true;
/* 030 */     java.lang.String value5 = null;
/* 031 */     if (!isNull6) {
/* 032 */
/* 033 */       isNull5 = false;
/* 034 */       if (!isNull5) {
/* 035 */
/* 036 */         Object funcResult2 = null;
/* 037 */         funcResult2 = value6.toString();
/* 038 */         value5 = (java.lang.String) funcResult2;
/* 039 */
/* 040 */       }
/* 041 */     }
/* 042 */     if (isNull5) {
/* 043 */       values[2] = null;
/* 044 */     } else {
/* 045 */       values[2] = value5;
/* 046 */     }
/* 047 */
/* 048 */   }
/* 049 */
/* 050 */
/* 051 */   private void apply_0(InternalRow i) {
/* 052 */
/* 053 */     boolean isNull2 = i.isNullAt(0);
/* 054 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 055 */     boolean isNull1 = true;
/* 056 */     java.lang.String value1 = null;
/* 057 */     if (!isNull2) {
/* 058 */
/* 059 */       isNull1 = false;
/* 060 */       if (!isNull1) {
/* 061 */
/* 062 */         Object funcResult = null;
/* 063 */         funcResult = value2.toString();
/* 064 */         value1 = (java.lang.String) funcResult;
/* 065 */
/* 066 */       }
/* 067 */     }
/* 068 */     if (isNull1) {
/* 069 */       values[0] = null;
/* 070 */     } else {
/* 071 */       values[0] = value1;
/* 072 */     }
/* 073 */
/* 074 */     boolean isNull4 = i.isNullAt(1);
/* 075 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 076 */     boolean isNull3 = true;
/* 077 */     java.lang.String value3 = null;
/* 078 */     if (!isNull4) {
/* 079 */
/* 080 */       isNull3 = false;
/* 081 */       if (!isNull3) {
/* 082 */
/* 083 */         Object funcResult1 = null;
/* 084 */         funcResult1 = value4.toString();
/* 085 */         value3 = (java.lang.String) funcResult1;
/* 086 */
/* 087 */       }
/* 088 */     }
/* 089 */     if (isNull3) {
/* 090 */       values[1] = null;
/* 091 */     } else {
/* 092 */       values[1] = value3;
/* 093 */     }
/* 094 */
/* 095 */   }
/* 096 */
/* 097 */
/* 098 */   public java.lang.Object apply(java.lang.Object _i) {
/* 099 */     InternalRow i = (InternalRow) _i;
/* 100 */
/* 101 */     values = new Object[3];
/* 102 */     apply_0(i);
/* 103 */     apply_1(i);
/* 104 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 105 */     if (false) {
/* 106 */       mutableRow.setNullAt(0);
/* 107 */     } else {
/* 108 */
/* 109 */       mutableRow.update(0, value);
/* 110 */     }
/* 111 */
/* 112 */     return mutableRow;
/* 113 */   }
/* 114 */ }
