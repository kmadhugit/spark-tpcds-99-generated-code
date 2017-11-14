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
/* 027 */     boolean isNull6 = i.isNullAt(5);
/* 028 */     int value6 = isNull6 ? -1 : (i.getInt(5));
/* 029 */     if (isNull6) {
/* 030 */       values[5] = null;
/* 031 */     } else {
/* 032 */       values[5] = value6;
/* 033 */     }
/* 034 */
/* 035 */     boolean isNull7 = i.isNullAt(6);
/* 036 */     int value7 = isNull7 ? -1 : (i.getInt(6));
/* 037 */     if (isNull7) {
/* 038 */       values[6] = null;
/* 039 */     } else {
/* 040 */       values[6] = value7;
/* 041 */     }
/* 042 */
/* 043 */     boolean isNull8 = i.isNullAt(7);
/* 044 */     int value8 = isNull8 ? -1 : (i.getInt(7));
/* 045 */     if (isNull8) {
/* 046 */       values[7] = null;
/* 047 */     } else {
/* 048 */       values[7] = value8;
/* 049 */     }
/* 050 */
/* 051 */     boolean isNull9 = i.isNullAt(8);
/* 052 */     double value9 = isNull9 ? -1.0 : (i.getDouble(8));
/* 053 */     if (isNull9) {
/* 054 */       values[8] = null;
/* 055 */     } else {
/* 056 */       values[8] = value9;
/* 057 */     }
/* 058 */
/* 059 */     boolean isNull10 = i.isNullAt(9);
/* 060 */     double value10 = isNull10 ? -1.0 : (i.getDouble(9));
/* 061 */     if (isNull10) {
/* 062 */       values[9] = null;
/* 063 */     } else {
/* 064 */       values[9] = value10;
/* 065 */     }
/* 066 */
/* 067 */   }
/* 068 */
/* 069 */
/* 070 */   private void apply_0(InternalRow i) {
/* 071 */
/* 072 */     boolean isNull1 = i.isNullAt(0);
/* 073 */     int value1 = isNull1 ? -1 : (i.getInt(0));
/* 074 */     if (isNull1) {
/* 075 */       values[0] = null;
/* 076 */     } else {
/* 077 */       values[0] = value1;
/* 078 */     }
/* 079 */
/* 080 */     boolean isNull2 = i.isNullAt(1);
/* 081 */     int value2 = isNull2 ? -1 : (i.getInt(1));
/* 082 */     if (isNull2) {
/* 083 */       values[1] = null;
/* 084 */     } else {
/* 085 */       values[1] = value2;
/* 086 */     }
/* 087 */
/* 088 */     boolean isNull3 = i.isNullAt(2);
/* 089 */     int value3 = isNull3 ? -1 : (i.getInt(2));
/* 090 */     if (isNull3) {
/* 091 */       values[2] = null;
/* 092 */     } else {
/* 093 */       values[2] = value3;
/* 094 */     }
/* 095 */
/* 096 */     boolean isNull4 = i.isNullAt(3);
/* 097 */     double value4 = isNull4 ? -1.0 : (i.getDouble(3));
/* 098 */     if (isNull4) {
/* 099 */       values[3] = null;
/* 100 */     } else {
/* 101 */       values[3] = value4;
/* 102 */     }
/* 103 */
/* 104 */     boolean isNull5 = i.isNullAt(4);
/* 105 */     double value5 = isNull5 ? -1.0 : (i.getDouble(4));
/* 106 */     if (isNull5) {
/* 107 */       values[4] = null;
/* 108 */     } else {
/* 109 */       values[4] = value5;
/* 110 */     }
/* 111 */
/* 112 */   }
/* 113 */
/* 114 */
/* 115 */   public java.lang.Object apply(java.lang.Object _i) {
/* 116 */     InternalRow i = (InternalRow) _i;
/* 117 */
/* 118 */     values = new Object[10];
/* 119 */     apply_0(i);
/* 120 */     apply_1(i);
/* 121 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 122 */     if (false) {
/* 123 */       mutableRow.setNullAt(0);
/* 124 */     } else {
/* 125 */
/* 126 */       mutableRow.update(0, value);
/* 127 */     }
/* 128 */
/* 129 */     return mutableRow;
/* 130 */   }
/* 131 */ }
