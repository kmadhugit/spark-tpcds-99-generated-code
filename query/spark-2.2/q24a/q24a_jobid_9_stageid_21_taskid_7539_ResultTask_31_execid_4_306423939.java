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
/* 048 */     boolean isNull7 = i.isNullAt(3);
/* 049 */     double value7 = isNull7 ? -1.0 : (i.getDouble(3));
/* 050 */     if (isNull7) {
/* 051 */       values[3] = null;
/* 052 */     } else {
/* 053 */       values[3] = value7;
/* 054 */     }
/* 055 */
/* 056 */   }
/* 057 */
/* 058 */
/* 059 */   private void apply_0(InternalRow i) {
/* 060 */
/* 061 */     boolean isNull2 = i.isNullAt(0);
/* 062 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 063 */     boolean isNull1 = true;
/* 064 */     java.lang.String value1 = null;
/* 065 */     if (!isNull2) {
/* 066 */
/* 067 */       isNull1 = false;
/* 068 */       if (!isNull1) {
/* 069 */
/* 070 */         Object funcResult = null;
/* 071 */         funcResult = value2.toString();
/* 072 */         value1 = (java.lang.String) funcResult;
/* 073 */
/* 074 */       }
/* 075 */     }
/* 076 */     if (isNull1) {
/* 077 */       values[0] = null;
/* 078 */     } else {
/* 079 */       values[0] = value1;
/* 080 */     }
/* 081 */
/* 082 */     boolean isNull4 = i.isNullAt(1);
/* 083 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 084 */     boolean isNull3 = true;
/* 085 */     java.lang.String value3 = null;
/* 086 */     if (!isNull4) {
/* 087 */
/* 088 */       isNull3 = false;
/* 089 */       if (!isNull3) {
/* 090 */
/* 091 */         Object funcResult1 = null;
/* 092 */         funcResult1 = value4.toString();
/* 093 */         value3 = (java.lang.String) funcResult1;
/* 094 */
/* 095 */       }
/* 096 */     }
/* 097 */     if (isNull3) {
/* 098 */       values[1] = null;
/* 099 */     } else {
/* 100 */       values[1] = value3;
/* 101 */     }
/* 102 */
/* 103 */   }
/* 104 */
/* 105 */
/* 106 */   public java.lang.Object apply(java.lang.Object _i) {
/* 107 */     InternalRow i = (InternalRow) _i;
/* 108 */
/* 109 */     values = new Object[4];
/* 110 */     apply_0(i);
/* 111 */     apply_1(i);
/* 112 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 113 */     if (false) {
/* 114 */       mutableRow.setNullAt(0);
/* 115 */     } else {
/* 116 */
/* 117 */       mutableRow.update(0, value);
/* 118 */     }
/* 119 */
/* 120 */     return mutableRow;
/* 121 */   }
/* 122 */ }
