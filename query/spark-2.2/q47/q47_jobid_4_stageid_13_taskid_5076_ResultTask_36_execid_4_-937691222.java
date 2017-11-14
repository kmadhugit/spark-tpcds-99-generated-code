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
/* 048 */     boolean isNull8 = i.isNullAt(3);
/* 049 */     UTF8String value8 = isNull8 ? null : (i.getUTF8String(3));
/* 050 */     boolean isNull7 = true;
/* 051 */     java.lang.String value7 = null;
/* 052 */     if (!isNull8) {
/* 053 */
/* 054 */       isNull7 = false;
/* 055 */       if (!isNull7) {
/* 056 */
/* 057 */         Object funcResult3 = null;
/* 058 */         funcResult3 = value8.toString();
/* 059 */         value7 = (java.lang.String) funcResult3;
/* 060 */
/* 061 */       }
/* 062 */     }
/* 063 */     if (isNull7) {
/* 064 */       values[3] = null;
/* 065 */     } else {
/* 066 */       values[3] = value7;
/* 067 */     }
/* 068 */
/* 069 */   }
/* 070 */
/* 071 */
/* 072 */   private void apply_3(InternalRow i) {
/* 073 */
/* 074 */     boolean isNull14 = i.isNullAt(9);
/* 075 */     double value14 = isNull14 ? -1.0 : (i.getDouble(9));
/* 076 */     if (isNull14) {
/* 077 */       values[9] = null;
/* 078 */     } else {
/* 079 */       values[9] = value14;
/* 080 */     }
/* 081 */
/* 082 */   }
/* 083 */
/* 084 */
/* 085 */   private void apply_0(InternalRow i) {
/* 086 */
/* 087 */     boolean isNull2 = i.isNullAt(0);
/* 088 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 089 */     boolean isNull1 = true;
/* 090 */     java.lang.String value1 = null;
/* 091 */     if (!isNull2) {
/* 092 */
/* 093 */       isNull1 = false;
/* 094 */       if (!isNull1) {
/* 095 */
/* 096 */         Object funcResult = null;
/* 097 */         funcResult = value2.toString();
/* 098 */         value1 = (java.lang.String) funcResult;
/* 099 */
/* 100 */       }
/* 101 */     }
/* 102 */     if (isNull1) {
/* 103 */       values[0] = null;
/* 104 */     } else {
/* 105 */       values[0] = value1;
/* 106 */     }
/* 107 */
/* 108 */     boolean isNull4 = i.isNullAt(1);
/* 109 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 110 */     boolean isNull3 = true;
/* 111 */     java.lang.String value3 = null;
/* 112 */     if (!isNull4) {
/* 113 */
/* 114 */       isNull3 = false;
/* 115 */       if (!isNull3) {
/* 116 */
/* 117 */         Object funcResult1 = null;
/* 118 */         funcResult1 = value4.toString();
/* 119 */         value3 = (java.lang.String) funcResult1;
/* 120 */
/* 121 */       }
/* 122 */     }
/* 123 */     if (isNull3) {
/* 124 */       values[1] = null;
/* 125 */     } else {
/* 126 */       values[1] = value3;
/* 127 */     }
/* 128 */
/* 129 */   }
/* 130 */
/* 131 */
/* 132 */   private void apply_2(InternalRow i) {
/* 133 */
/* 134 */     boolean isNull9 = i.isNullAt(4);
/* 135 */     int value9 = isNull9 ? -1 : (i.getInt(4));
/* 136 */     if (isNull9) {
/* 137 */       values[4] = null;
/* 138 */     } else {
/* 139 */       values[4] = value9;
/* 140 */     }
/* 141 */
/* 142 */     boolean isNull10 = i.isNullAt(5);
/* 143 */     int value10 = isNull10 ? -1 : (i.getInt(5));
/* 144 */     if (isNull10) {
/* 145 */       values[5] = null;
/* 146 */     } else {
/* 147 */       values[5] = value10;
/* 148 */     }
/* 149 */
/* 150 */     boolean isNull11 = i.isNullAt(6);
/* 151 */     double value11 = isNull11 ? -1.0 : (i.getDouble(6));
/* 152 */     if (isNull11) {
/* 153 */       values[6] = null;
/* 154 */     } else {
/* 155 */       values[6] = value11;
/* 156 */     }
/* 157 */
/* 158 */     boolean isNull12 = i.isNullAt(7);
/* 159 */     double value12 = isNull12 ? -1.0 : (i.getDouble(7));
/* 160 */     if (isNull12) {
/* 161 */       values[7] = null;
/* 162 */     } else {
/* 163 */       values[7] = value12;
/* 164 */     }
/* 165 */
/* 166 */     boolean isNull13 = i.isNullAt(8);
/* 167 */     double value13 = isNull13 ? -1.0 : (i.getDouble(8));
/* 168 */     if (isNull13) {
/* 169 */       values[8] = null;
/* 170 */     } else {
/* 171 */       values[8] = value13;
/* 172 */     }
/* 173 */
/* 174 */   }
/* 175 */
/* 176 */
/* 177 */   public java.lang.Object apply(java.lang.Object _i) {
/* 178 */     InternalRow i = (InternalRow) _i;
/* 179 */
/* 180 */     values = new Object[10];
/* 181 */     apply_0(i);
/* 182 */     apply_1(i);
/* 183 */     apply_2(i);
/* 184 */     apply_3(i);
/* 185 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 186 */     if (false) {
/* 187 */       mutableRow.setNullAt(0);
/* 188 */     } else {
/* 189 */
/* 190 */       mutableRow.update(0, value);
/* 191 */     }
/* 192 */
/* 193 */     return mutableRow;
/* 194 */   }
/* 195 */ }
