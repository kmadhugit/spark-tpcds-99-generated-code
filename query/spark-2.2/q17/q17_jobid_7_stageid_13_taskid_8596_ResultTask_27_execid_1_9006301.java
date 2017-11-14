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
/* 048 */     long value7 = i.getLong(3);
/* 049 */     if (false) {
/* 050 */       values[3] = null;
/* 051 */     } else {
/* 052 */       values[3] = value7;
/* 053 */     }
/* 054 */
/* 055 */     boolean isNull8 = i.isNullAt(4);
/* 056 */     double value8 = isNull8 ? -1.0 : (i.getDouble(4));
/* 057 */     if (isNull8) {
/* 058 */       values[4] = null;
/* 059 */     } else {
/* 060 */       values[4] = value8;
/* 061 */     }
/* 062 */
/* 063 */     boolean isNull9 = i.isNullAt(5);
/* 064 */     double value9 = isNull9 ? -1.0 : (i.getDouble(5));
/* 065 */     if (isNull9) {
/* 066 */       values[5] = null;
/* 067 */     } else {
/* 068 */       values[5] = value9;
/* 069 */     }
/* 070 */
/* 071 */   }
/* 072 */
/* 073 */
/* 074 */   private void apply_3(InternalRow i) {
/* 075 */
/* 076 */     long value15 = i.getLong(11);
/* 077 */     if (false) {
/* 078 */       values[11] = null;
/* 079 */     } else {
/* 080 */       values[11] = value15;
/* 081 */     }
/* 082 */
/* 083 */     boolean isNull16 = i.isNullAt(12);
/* 084 */     double value16 = isNull16 ? -1.0 : (i.getDouble(12));
/* 085 */     if (isNull16) {
/* 086 */       values[12] = null;
/* 087 */     } else {
/* 088 */       values[12] = value16;
/* 089 */     }
/* 090 */
/* 091 */     boolean isNull17 = i.isNullAt(13);
/* 092 */     double value17 = isNull17 ? -1.0 : (i.getDouble(13));
/* 093 */     if (isNull17) {
/* 094 */       values[13] = null;
/* 095 */     } else {
/* 096 */       values[13] = value17;
/* 097 */     }
/* 098 */
/* 099 */     boolean isNull18 = i.isNullAt(14);
/* 100 */     double value18 = isNull18 ? -1.0 : (i.getDouble(14));
/* 101 */     if (isNull18) {
/* 102 */       values[14] = null;
/* 103 */     } else {
/* 104 */       values[14] = value18;
/* 105 */     }
/* 106 */
/* 107 */   }
/* 108 */
/* 109 */
/* 110 */   private void apply_0(InternalRow i) {
/* 111 */
/* 112 */     boolean isNull2 = i.isNullAt(0);
/* 113 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 114 */     boolean isNull1 = true;
/* 115 */     java.lang.String value1 = null;
/* 116 */     if (!isNull2) {
/* 117 */
/* 118 */       isNull1 = false;
/* 119 */       if (!isNull1) {
/* 120 */
/* 121 */         Object funcResult = null;
/* 122 */         funcResult = value2.toString();
/* 123 */         value1 = (java.lang.String) funcResult;
/* 124 */
/* 125 */       }
/* 126 */     }
/* 127 */     if (isNull1) {
/* 128 */       values[0] = null;
/* 129 */     } else {
/* 130 */       values[0] = value1;
/* 131 */     }
/* 132 */
/* 133 */     boolean isNull4 = i.isNullAt(1);
/* 134 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 135 */     boolean isNull3 = true;
/* 136 */     java.lang.String value3 = null;
/* 137 */     if (!isNull4) {
/* 138 */
/* 139 */       isNull3 = false;
/* 140 */       if (!isNull3) {
/* 141 */
/* 142 */         Object funcResult1 = null;
/* 143 */         funcResult1 = value4.toString();
/* 144 */         value3 = (java.lang.String) funcResult1;
/* 145 */
/* 146 */       }
/* 147 */     }
/* 148 */     if (isNull3) {
/* 149 */       values[1] = null;
/* 150 */     } else {
/* 151 */       values[1] = value3;
/* 152 */     }
/* 153 */
/* 154 */   }
/* 155 */
/* 156 */
/* 157 */   private void apply_2(InternalRow i) {
/* 158 */
/* 159 */     boolean isNull10 = i.isNullAt(6);
/* 160 */     double value10 = isNull10 ? -1.0 : (i.getDouble(6));
/* 161 */     if (isNull10) {
/* 162 */       values[6] = null;
/* 163 */     } else {
/* 164 */       values[6] = value10;
/* 165 */     }
/* 166 */
/* 167 */     long value11 = i.getLong(7);
/* 168 */     if (false) {
/* 169 */       values[7] = null;
/* 170 */     } else {
/* 171 */       values[7] = value11;
/* 172 */     }
/* 173 */
/* 174 */     boolean isNull12 = i.isNullAt(8);
/* 175 */     double value12 = isNull12 ? -1.0 : (i.getDouble(8));
/* 176 */     if (isNull12) {
/* 177 */       values[8] = null;
/* 178 */     } else {
/* 179 */       values[8] = value12;
/* 180 */     }
/* 181 */
/* 182 */     boolean isNull13 = i.isNullAt(9);
/* 183 */     double value13 = isNull13 ? -1.0 : (i.getDouble(9));
/* 184 */     if (isNull13) {
/* 185 */       values[9] = null;
/* 186 */     } else {
/* 187 */       values[9] = value13;
/* 188 */     }
/* 189 */
/* 190 */     boolean isNull14 = i.isNullAt(10);
/* 191 */     double value14 = isNull14 ? -1.0 : (i.getDouble(10));
/* 192 */     if (isNull14) {
/* 193 */       values[10] = null;
/* 194 */     } else {
/* 195 */       values[10] = value14;
/* 196 */     }
/* 197 */
/* 198 */   }
/* 199 */
/* 200 */
/* 201 */   public java.lang.Object apply(java.lang.Object _i) {
/* 202 */     InternalRow i = (InternalRow) _i;
/* 203 */
/* 204 */     values = new Object[15];
/* 205 */     apply_0(i);
/* 206 */     apply_1(i);
/* 207 */     apply_2(i);
/* 208 */     apply_3(i);
/* 209 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 210 */     if (false) {
/* 211 */       mutableRow.setNullAt(0);
/* 212 */     } else {
/* 213 */
/* 214 */       mutableRow.update(0, value);
/* 215 */     }
/* 216 */
/* 217 */     return mutableRow;
/* 218 */   }
/* 219 */ }
