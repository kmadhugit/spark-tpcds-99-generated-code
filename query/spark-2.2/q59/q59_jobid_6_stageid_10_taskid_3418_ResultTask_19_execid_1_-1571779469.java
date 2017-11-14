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
/* 028 */     int value5 = isNull5 ? -1 : (i.getInt(2));
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
/* 051 */     boolean isNull8 = i.isNullAt(5);
/* 052 */     double value8 = isNull8 ? -1.0 : (i.getDouble(5));
/* 053 */     if (isNull8) {
/* 054 */       values[5] = null;
/* 055 */     } else {
/* 056 */       values[5] = value8;
/* 057 */     }
/* 058 */
/* 059 */     boolean isNull9 = i.isNullAt(6);
/* 060 */     double value9 = isNull9 ? -1.0 : (i.getDouble(6));
/* 061 */     if (isNull9) {
/* 062 */       values[6] = null;
/* 063 */     } else {
/* 064 */       values[6] = value9;
/* 065 */     }
/* 066 */
/* 067 */   }
/* 068 */
/* 069 */
/* 070 */   private void apply_0(InternalRow i) {
/* 071 */
/* 072 */     boolean isNull2 = i.isNullAt(0);
/* 073 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 074 */     boolean isNull1 = true;
/* 075 */     java.lang.String value1 = null;
/* 076 */     if (!isNull2) {
/* 077 */
/* 078 */       isNull1 = false;
/* 079 */       if (!isNull1) {
/* 080 */
/* 081 */         Object funcResult = null;
/* 082 */         funcResult = value2.toString();
/* 083 */         value1 = (java.lang.String) funcResult;
/* 084 */
/* 085 */       }
/* 086 */     }
/* 087 */     if (isNull1) {
/* 088 */       values[0] = null;
/* 089 */     } else {
/* 090 */       values[0] = value1;
/* 091 */     }
/* 092 */
/* 093 */     boolean isNull4 = i.isNullAt(1);
/* 094 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 095 */     boolean isNull3 = true;
/* 096 */     java.lang.String value3 = null;
/* 097 */     if (!isNull4) {
/* 098 */
/* 099 */       isNull3 = false;
/* 100 */       if (!isNull3) {
/* 101 */
/* 102 */         Object funcResult1 = null;
/* 103 */         funcResult1 = value4.toString();
/* 104 */         value3 = (java.lang.String) funcResult1;
/* 105 */
/* 106 */       }
/* 107 */     }
/* 108 */     if (isNull3) {
/* 109 */       values[1] = null;
/* 110 */     } else {
/* 111 */       values[1] = value3;
/* 112 */     }
/* 113 */
/* 114 */   }
/* 115 */
/* 116 */
/* 117 */   private void apply_2(InternalRow i) {
/* 118 */
/* 119 */     boolean isNull10 = i.isNullAt(7);
/* 120 */     double value10 = isNull10 ? -1.0 : (i.getDouble(7));
/* 121 */     if (isNull10) {
/* 122 */       values[7] = null;
/* 123 */     } else {
/* 124 */       values[7] = value10;
/* 125 */     }
/* 126 */
/* 127 */     boolean isNull11 = i.isNullAt(8);
/* 128 */     double value11 = isNull11 ? -1.0 : (i.getDouble(8));
/* 129 */     if (isNull11) {
/* 130 */       values[8] = null;
/* 131 */     } else {
/* 132 */       values[8] = value11;
/* 133 */     }
/* 134 */
/* 135 */     boolean isNull12 = i.isNullAt(9);
/* 136 */     double value12 = isNull12 ? -1.0 : (i.getDouble(9));
/* 137 */     if (isNull12) {
/* 138 */       values[9] = null;
/* 139 */     } else {
/* 140 */       values[9] = value12;
/* 141 */     }
/* 142 */
/* 143 */   }
/* 144 */
/* 145 */
/* 146 */   public java.lang.Object apply(java.lang.Object _i) {
/* 147 */     InternalRow i = (InternalRow) _i;
/* 148 */
/* 149 */     values = new Object[10];
/* 150 */     apply_0(i);
/* 151 */     apply_1(i);
/* 152 */     apply_2(i);
/* 153 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 154 */     if (false) {
/* 155 */       mutableRow.setNullAt(0);
/* 156 */     } else {
/* 157 */
/* 158 */       mutableRow.update(0, value);
/* 159 */     }
/* 160 */
/* 161 */     return mutableRow;
/* 162 */   }
/* 163 */ }
