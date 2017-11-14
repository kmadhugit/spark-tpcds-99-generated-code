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
/* 027 */     boolean isNull7 = i.isNullAt(6);
/* 028 */     int value7 = isNull7 ? -1 : (i.getInt(6));
/* 029 */     if (isNull7) {
/* 030 */       values[6] = null;
/* 031 */     } else {
/* 032 */       values[6] = value7;
/* 033 */     }
/* 034 */
/* 035 */     boolean isNull8 = i.isNullAt(7);
/* 036 */     int value8 = isNull8 ? -1 : (i.getInt(7));
/* 037 */     if (isNull8) {
/* 038 */       values[7] = null;
/* 039 */     } else {
/* 040 */       values[7] = value8;
/* 041 */     }
/* 042 */
/* 043 */     boolean isNull9 = i.isNullAt(8);
/* 044 */     int value9 = isNull9 ? -1 : (i.getInt(8));
/* 045 */     if (isNull9) {
/* 046 */       values[8] = null;
/* 047 */     } else {
/* 048 */       values[8] = value9;
/* 049 */     }
/* 050 */
/* 051 */     boolean isNull10 = i.isNullAt(9);
/* 052 */     int value10 = isNull10 ? -1 : (i.getInt(9));
/* 053 */     if (isNull10) {
/* 054 */       values[9] = null;
/* 055 */     } else {
/* 056 */       values[9] = value10;
/* 057 */     }
/* 058 */
/* 059 */     boolean isNull11 = i.isNullAt(10);
/* 060 */     int value11 = isNull11 ? -1 : (i.getInt(10));
/* 061 */     if (isNull11) {
/* 062 */       values[10] = null;
/* 063 */     } else {
/* 064 */       values[10] = value11;
/* 065 */     }
/* 066 */
/* 067 */   }
/* 068 */
/* 069 */
/* 070 */   private void apply_0(InternalRow i) {
/* 071 */
/* 072 */     long value1 = i.getLong(0);
/* 073 */     if (false) {
/* 074 */       values[0] = null;
/* 075 */     } else {
/* 076 */       values[0] = value1;
/* 077 */     }
/* 078 */
/* 079 */     long value2 = i.getLong(1);
/* 080 */     if (false) {
/* 081 */       values[1] = null;
/* 082 */     } else {
/* 083 */       values[1] = value2;
/* 084 */     }
/* 085 */
/* 086 */     long value3 = i.getLong(2);
/* 087 */     if (false) {
/* 088 */       values[2] = null;
/* 089 */     } else {
/* 090 */       values[2] = value3;
/* 091 */     }
/* 092 */
/* 093 */     boolean isNull4 = i.isNullAt(3);
/* 094 */     int value4 = isNull4 ? -1 : (i.getInt(3));
/* 095 */     if (isNull4) {
/* 096 */       values[3] = null;
/* 097 */     } else {
/* 098 */       values[3] = value4;
/* 099 */     }
/* 100 */
/* 101 */     boolean isNull5 = i.isNullAt(4);
/* 102 */     int value5 = isNull5 ? -1 : (i.getInt(4));
/* 103 */     if (isNull5) {
/* 104 */       values[4] = null;
/* 105 */     } else {
/* 106 */       values[4] = value5;
/* 107 */     }
/* 108 */
/* 109 */     boolean isNull6 = i.isNullAt(5);
/* 110 */     int value6 = isNull6 ? -1 : (i.getInt(5));
/* 111 */     if (isNull6) {
/* 112 */       values[5] = null;
/* 113 */     } else {
/* 114 */       values[5] = value6;
/* 115 */     }
/* 116 */
/* 117 */   }
/* 118 */
/* 119 */
/* 120 */   private void apply_2(InternalRow i) {
/* 121 */
/* 122 */     boolean isNull12 = i.isNullAt(11);
/* 123 */     int value12 = isNull12 ? -1 : (i.getInt(11));
/* 124 */     if (isNull12) {
/* 125 */       values[11] = null;
/* 126 */     } else {
/* 127 */       values[11] = value12;
/* 128 */     }
/* 129 */
/* 130 */   }
/* 131 */
/* 132 */
/* 133 */   public java.lang.Object apply(java.lang.Object _i) {
/* 134 */     InternalRow i = (InternalRow) _i;
/* 135 */
/* 136 */     values = new Object[12];
/* 137 */     apply_0(i);
/* 138 */     apply_1(i);
/* 139 */     apply_2(i);
/* 140 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 141 */     if (false) {
/* 142 */       mutableRow.setNullAt(0);
/* 143 */     } else {
/* 144 */
/* 145 */       mutableRow.update(0, value);
/* 146 */     }
/* 147 */
/* 148 */     return mutableRow;
/* 149 */   }
/* 150 */ }
