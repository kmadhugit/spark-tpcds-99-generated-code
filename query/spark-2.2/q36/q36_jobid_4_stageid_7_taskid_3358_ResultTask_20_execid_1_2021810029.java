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
/* 027 */     byte value6 = i.getByte(3);
/* 028 */     if (false) {
/* 029 */       values[3] = null;
/* 030 */     } else {
/* 031 */       values[3] = value6;
/* 032 */     }
/* 033 */
/* 034 */     boolean isNull7 = i.isNullAt(4);
/* 035 */     int value7 = isNull7 ? -1 : (i.getInt(4));
/* 036 */     if (isNull7) {
/* 037 */       values[4] = null;
/* 038 */     } else {
/* 039 */       values[4] = value7;
/* 040 */     }
/* 041 */
/* 042 */   }
/* 043 */
/* 044 */
/* 045 */   private void apply_0(InternalRow i) {
/* 046 */
/* 047 */     boolean isNull1 = i.isNullAt(0);
/* 048 */     double value1 = isNull1 ? -1.0 : (i.getDouble(0));
/* 049 */     if (isNull1) {
/* 050 */       values[0] = null;
/* 051 */     } else {
/* 052 */       values[0] = value1;
/* 053 */     }
/* 054 */
/* 055 */     boolean isNull3 = i.isNullAt(1);
/* 056 */     UTF8String value3 = isNull3 ? null : (i.getUTF8String(1));
/* 057 */     boolean isNull2 = true;
/* 058 */     java.lang.String value2 = null;
/* 059 */     if (!isNull3) {
/* 060 */
/* 061 */       isNull2 = false;
/* 062 */       if (!isNull2) {
/* 063 */
/* 064 */         Object funcResult = null;
/* 065 */         funcResult = value3.toString();
/* 066 */         value2 = (java.lang.String) funcResult;
/* 067 */
/* 068 */       }
/* 069 */     }
/* 070 */     if (isNull2) {
/* 071 */       values[1] = null;
/* 072 */     } else {
/* 073 */       values[1] = value2;
/* 074 */     }
/* 075 */
/* 076 */     boolean isNull5 = i.isNullAt(2);
/* 077 */     UTF8String value5 = isNull5 ? null : (i.getUTF8String(2));
/* 078 */     boolean isNull4 = true;
/* 079 */     java.lang.String value4 = null;
/* 080 */     if (!isNull5) {
/* 081 */
/* 082 */       isNull4 = false;
/* 083 */       if (!isNull4) {
/* 084 */
/* 085 */         Object funcResult1 = null;
/* 086 */         funcResult1 = value5.toString();
/* 087 */         value4 = (java.lang.String) funcResult1;
/* 088 */
/* 089 */       }
/* 090 */     }
/* 091 */     if (isNull4) {
/* 092 */       values[2] = null;
/* 093 */     } else {
/* 094 */       values[2] = value4;
/* 095 */     }
/* 096 */
/* 097 */   }
/* 098 */
/* 099 */
/* 100 */   public java.lang.Object apply(java.lang.Object _i) {
/* 101 */     InternalRow i = (InternalRow) _i;
/* 102 */
/* 103 */     values = new Object[5];
/* 104 */     apply_0(i);
/* 105 */     apply_1(i);
/* 106 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 107 */     if (false) {
/* 108 */       mutableRow.setNullAt(0);
/* 109 */     } else {
/* 110 */
/* 111 */       mutableRow.update(0, value);
/* 112 */     }
/* 113 */
/* 114 */     return mutableRow;
/* 115 */   }
/* 116 */ }
