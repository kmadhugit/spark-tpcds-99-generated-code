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
/* 056 */     int value8 = isNull8 ? -1 : (i.getInt(4));
/* 057 */     if (isNull8) {
/* 058 */       values[4] = null;
/* 059 */     } else {
/* 060 */       values[4] = value8;
/* 061 */     }
/* 062 */
/* 063 */     long value9 = i.getLong(5);
/* 064 */     if (false) {
/* 065 */       values[5] = null;
/* 066 */     } else {
/* 067 */       values[5] = value9;
/* 068 */     }
/* 069 */
/* 070 */   }
/* 071 */
/* 072 */
/* 073 */   private void apply_3(InternalRow i) {
/* 074 */
/* 075 */     boolean isNull15 = i.isNullAt(10);
/* 076 */     int value15 = isNull15 ? -1 : (i.getInt(10));
/* 077 */     if (isNull15) {
/* 078 */       values[10] = null;
/* 079 */     } else {
/* 080 */       values[10] = value15;
/* 081 */     }
/* 082 */
/* 083 */     long value16 = i.getLong(11);
/* 084 */     if (false) {
/* 085 */       values[11] = null;
/* 086 */     } else {
/* 087 */       values[11] = value16;
/* 088 */     }
/* 089 */
/* 090 */     boolean isNull17 = i.isNullAt(12);
/* 091 */     int value17 = isNull17 ? -1 : (i.getInt(12));
/* 092 */     if (isNull17) {
/* 093 */       values[12] = null;
/* 094 */     } else {
/* 095 */       values[12] = value17;
/* 096 */     }
/* 097 */
/* 098 */     long value18 = i.getLong(13);
/* 099 */     if (false) {
/* 100 */       values[13] = null;
/* 101 */     } else {
/* 102 */       values[13] = value18;
/* 103 */     }
/* 104 */
/* 105 */   }
/* 106 */
/* 107 */
/* 108 */   private void apply_0(InternalRow i) {
/* 109 */
/* 110 */     boolean isNull2 = i.isNullAt(0);
/* 111 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 112 */     boolean isNull1 = true;
/* 113 */     java.lang.String value1 = null;
/* 114 */     if (!isNull2) {
/* 115 */
/* 116 */       isNull1 = false;
/* 117 */       if (!isNull1) {
/* 118 */
/* 119 */         Object funcResult = null;
/* 120 */         funcResult = value2.toString();
/* 121 */         value1 = (java.lang.String) funcResult;
/* 122 */
/* 123 */       }
/* 124 */     }
/* 125 */     if (isNull1) {
/* 126 */       values[0] = null;
/* 127 */     } else {
/* 128 */       values[0] = value1;
/* 129 */     }
/* 130 */
/* 131 */     boolean isNull4 = i.isNullAt(1);
/* 132 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 133 */     boolean isNull3 = true;
/* 134 */     java.lang.String value3 = null;
/* 135 */     if (!isNull4) {
/* 136 */
/* 137 */       isNull3 = false;
/* 138 */       if (!isNull3) {
/* 139 */
/* 140 */         Object funcResult1 = null;
/* 141 */         funcResult1 = value4.toString();
/* 142 */         value3 = (java.lang.String) funcResult1;
/* 143 */
/* 144 */       }
/* 145 */     }
/* 146 */     if (isNull3) {
/* 147 */       values[1] = null;
/* 148 */     } else {
/* 149 */       values[1] = value3;
/* 150 */     }
/* 151 */
/* 152 */   }
/* 153 */
/* 154 */
/* 155 */   private void apply_2(InternalRow i) {
/* 156 */
/* 157 */     boolean isNull11 = i.isNullAt(6);
/* 158 */     UTF8String value11 = isNull11 ? null : (i.getUTF8String(6));
/* 159 */     boolean isNull10 = true;
/* 160 */     java.lang.String value10 = null;
/* 161 */     if (!isNull11) {
/* 162 */
/* 163 */       isNull10 = false;
/* 164 */       if (!isNull10) {
/* 165 */
/* 166 */         Object funcResult3 = null;
/* 167 */         funcResult3 = value11.toString();
/* 168 */         value10 = (java.lang.String) funcResult3;
/* 169 */
/* 170 */       }
/* 171 */     }
/* 172 */     if (isNull10) {
/* 173 */       values[6] = null;
/* 174 */     } else {
/* 175 */       values[6] = value10;
/* 176 */     }
/* 177 */
/* 178 */     long value12 = i.getLong(7);
/* 179 */     if (false) {
/* 180 */       values[7] = null;
/* 181 */     } else {
/* 182 */       values[7] = value12;
/* 183 */     }
/* 184 */
/* 185 */     boolean isNull13 = i.isNullAt(8);
/* 186 */     int value13 = isNull13 ? -1 : (i.getInt(8));
/* 187 */     if (isNull13) {
/* 188 */       values[8] = null;
/* 189 */     } else {
/* 190 */       values[8] = value13;
/* 191 */     }
/* 192 */
/* 193 */     long value14 = i.getLong(9);
/* 194 */     if (false) {
/* 195 */       values[9] = null;
/* 196 */     } else {
/* 197 */       values[9] = value14;
/* 198 */     }
/* 199 */
/* 200 */   }
/* 201 */
/* 202 */
/* 203 */   public java.lang.Object apply(java.lang.Object _i) {
/* 204 */     InternalRow i = (InternalRow) _i;
/* 205 */
/* 206 */     values = new Object[14];
/* 207 */     apply_0(i);
/* 208 */     apply_1(i);
/* 209 */     apply_2(i);
/* 210 */     apply_3(i);
/* 211 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 212 */     if (false) {
/* 213 */       mutableRow.setNullAt(0);
/* 214 */     } else {
/* 215 */
/* 216 */       mutableRow.update(0, value);
/* 217 */     }
/* 218 */
/* 219 */     return mutableRow;
/* 220 */   }
/* 221 */ }
