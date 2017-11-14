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
/* 025 */   private void apply_4(InternalRow i) {
/* 026 */
/* 027 */     boolean isNull20 = i.isNullAt(16);
/* 028 */     double value20 = isNull20 ? -1.0 : (i.getDouble(16));
/* 029 */     if (isNull20) {
/* 030 */       values[16] = null;
/* 031 */     } else {
/* 032 */       values[16] = value20;
/* 033 */     }
/* 034 */
/* 035 */   }
/* 036 */
/* 037 */
/* 038 */   private void apply_1(InternalRow i) {
/* 039 */
/* 040 */     boolean isNull6 = i.isNullAt(2);
/* 041 */     UTF8String value6 = isNull6 ? null : (i.getUTF8String(2));
/* 042 */     boolean isNull5 = true;
/* 043 */     java.lang.String value5 = null;
/* 044 */     if (!isNull6) {
/* 045 */
/* 046 */       isNull5 = false;
/* 047 */       if (!isNull5) {
/* 048 */
/* 049 */         Object funcResult2 = null;
/* 050 */         funcResult2 = value6.toString();
/* 051 */         value5 = (java.lang.String) funcResult2;
/* 052 */
/* 053 */       }
/* 054 */     }
/* 055 */     if (isNull5) {
/* 056 */       values[2] = null;
/* 057 */     } else {
/* 058 */       values[2] = value5;
/* 059 */     }
/* 060 */
/* 061 */     long value7 = i.getLong(3);
/* 062 */     if (false) {
/* 063 */       values[3] = null;
/* 064 */     } else {
/* 065 */       values[3] = value7;
/* 066 */     }
/* 067 */
/* 068 */     boolean isNull8 = i.isNullAt(4);
/* 069 */     int value8 = isNull8 ? -1 : (i.getInt(4));
/* 070 */     if (isNull8) {
/* 071 */       values[4] = null;
/* 072 */     } else {
/* 073 */       values[4] = value8;
/* 074 */     }
/* 075 */
/* 076 */     boolean isNull9 = i.isNullAt(5);
/* 077 */     int value9 = isNull9 ? -1 : (i.getInt(5));
/* 078 */     if (isNull9) {
/* 079 */       values[5] = null;
/* 080 */     } else {
/* 081 */       values[5] = value9;
/* 082 */     }
/* 083 */
/* 084 */   }
/* 085 */
/* 086 */
/* 087 */   private void apply_3(InternalRow i) {
/* 088 */
/* 089 */     boolean isNull15 = i.isNullAt(11);
/* 090 */     double value15 = isNull15 ? -1.0 : (i.getDouble(11));
/* 091 */     if (isNull15) {
/* 092 */       values[11] = null;
/* 093 */     } else {
/* 094 */       values[11] = value15;
/* 095 */     }
/* 096 */
/* 097 */     boolean isNull16 = i.isNullAt(12);
/* 098 */     int value16 = isNull16 ? -1 : (i.getInt(12));
/* 099 */     if (isNull16) {
/* 100 */       values[12] = null;
/* 101 */     } else {
/* 102 */       values[12] = value16;
/* 103 */     }
/* 104 */
/* 105 */     long value17 = i.getLong(13);
/* 106 */     if (false) {
/* 107 */       values[13] = null;
/* 108 */     } else {
/* 109 */       values[13] = value17;
/* 110 */     }
/* 111 */
/* 112 */     boolean isNull18 = i.isNullAt(14);
/* 113 */     int value18 = isNull18 ? -1 : (i.getInt(14));
/* 114 */     if (isNull18) {
/* 115 */       values[14] = null;
/* 116 */     } else {
/* 117 */       values[14] = value18;
/* 118 */     }
/* 119 */
/* 120 */     boolean isNull19 = i.isNullAt(15);
/* 121 */     int value19 = isNull19 ? -1 : (i.getInt(15));
/* 122 */     if (isNull19) {
/* 123 */       values[15] = null;
/* 124 */     } else {
/* 125 */       values[15] = value19;
/* 126 */     }
/* 127 */
/* 128 */   }
/* 129 */
/* 130 */
/* 131 */   private void apply_0(InternalRow i) {
/* 132 */
/* 133 */     boolean isNull2 = i.isNullAt(0);
/* 134 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 135 */     boolean isNull1 = true;
/* 136 */     java.lang.String value1 = null;
/* 137 */     if (!isNull2) {
/* 138 */
/* 139 */       isNull1 = false;
/* 140 */       if (!isNull1) {
/* 141 */
/* 142 */         Object funcResult = null;
/* 143 */         funcResult = value2.toString();
/* 144 */         value1 = (java.lang.String) funcResult;
/* 145 */
/* 146 */       }
/* 147 */     }
/* 148 */     if (isNull1) {
/* 149 */       values[0] = null;
/* 150 */     } else {
/* 151 */       values[0] = value1;
/* 152 */     }
/* 153 */
/* 154 */     boolean isNull4 = i.isNullAt(1);
/* 155 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 156 */     boolean isNull3 = true;
/* 157 */     java.lang.String value3 = null;
/* 158 */     if (!isNull4) {
/* 159 */
/* 160 */       isNull3 = false;
/* 161 */       if (!isNull3) {
/* 162 */
/* 163 */         Object funcResult1 = null;
/* 164 */         funcResult1 = value4.toString();
/* 165 */         value3 = (java.lang.String) funcResult1;
/* 166 */
/* 167 */       }
/* 168 */     }
/* 169 */     if (isNull3) {
/* 170 */       values[1] = null;
/* 171 */     } else {
/* 172 */       values[1] = value3;
/* 173 */     }
/* 174 */
/* 175 */   }
/* 176 */
/* 177 */
/* 178 */   private void apply_2(InternalRow i) {
/* 179 */
/* 180 */     boolean isNull10 = i.isNullAt(6);
/* 181 */     double value10 = isNull10 ? -1.0 : (i.getDouble(6));
/* 182 */     if (isNull10) {
/* 183 */       values[6] = null;
/* 184 */     } else {
/* 185 */       values[6] = value10;
/* 186 */     }
/* 187 */
/* 188 */     boolean isNull11 = i.isNullAt(7);
/* 189 */     int value11 = isNull11 ? -1 : (i.getInt(7));
/* 190 */     if (isNull11) {
/* 191 */       values[7] = null;
/* 192 */     } else {
/* 193 */       values[7] = value11;
/* 194 */     }
/* 195 */
/* 196 */     long value12 = i.getLong(8);
/* 197 */     if (false) {
/* 198 */       values[8] = null;
/* 199 */     } else {
/* 200 */       values[8] = value12;
/* 201 */     }
/* 202 */
/* 203 */     boolean isNull13 = i.isNullAt(9);
/* 204 */     int value13 = isNull13 ? -1 : (i.getInt(9));
/* 205 */     if (isNull13) {
/* 206 */       values[9] = null;
/* 207 */     } else {
/* 208 */       values[9] = value13;
/* 209 */     }
/* 210 */
/* 211 */     boolean isNull14 = i.isNullAt(10);
/* 212 */     int value14 = isNull14 ? -1 : (i.getInt(10));
/* 213 */     if (isNull14) {
/* 214 */       values[10] = null;
/* 215 */     } else {
/* 216 */       values[10] = value14;
/* 217 */     }
/* 218 */
/* 219 */   }
/* 220 */
/* 221 */
/* 222 */   public java.lang.Object apply(java.lang.Object _i) {
/* 223 */     InternalRow i = (InternalRow) _i;
/* 224 */
/* 225 */     values = new Object[17];
/* 226 */     apply_0(i);
/* 227 */     apply_1(i);
/* 228 */     apply_2(i);
/* 229 */     apply_3(i);
/* 230 */     apply_4(i);
/* 231 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 232 */     if (false) {
/* 233 */       mutableRow.setNullAt(0);
/* 234 */     } else {
/* 235 */
/* 236 */       mutableRow.update(0, value);
/* 237 */     }
/* 238 */
/* 239 */     return mutableRow;
/* 240 */   }
/* 241 */ }
