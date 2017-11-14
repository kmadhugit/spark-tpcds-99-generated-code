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
/* 074 */     boolean isNull14 = i.isNullAt(6);
/* 075 */     UTF8String value14 = isNull14 ? null : (i.getUTF8String(6));
/* 076 */     boolean isNull13 = true;
/* 077 */     java.lang.String value13 = null;
/* 078 */     if (!isNull14) {
/* 079 */
/* 080 */       isNull13 = false;
/* 081 */       if (!isNull13) {
/* 082 */
/* 083 */         Object funcResult6 = null;
/* 084 */         funcResult6 = value14.toString();
/* 085 */         value13 = (java.lang.String) funcResult6;
/* 086 */
/* 087 */       }
/* 088 */     }
/* 089 */     if (isNull13) {
/* 090 */       values[6] = null;
/* 091 */     } else {
/* 092 */       values[6] = value13;
/* 093 */     }
/* 094 */
/* 095 */   }
/* 096 */
/* 097 */
/* 098 */   private void apply_0(InternalRow i) {
/* 099 */
/* 100 */     boolean isNull2 = i.isNullAt(0);
/* 101 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 102 */     boolean isNull1 = true;
/* 103 */     java.lang.String value1 = null;
/* 104 */     if (!isNull2) {
/* 105 */
/* 106 */       isNull1 = false;
/* 107 */       if (!isNull1) {
/* 108 */
/* 109 */         Object funcResult = null;
/* 110 */         funcResult = value2.toString();
/* 111 */         value1 = (java.lang.String) funcResult;
/* 112 */
/* 113 */       }
/* 114 */     }
/* 115 */     if (isNull1) {
/* 116 */       values[0] = null;
/* 117 */     } else {
/* 118 */       values[0] = value1;
/* 119 */     }
/* 120 */
/* 121 */     boolean isNull4 = i.isNullAt(1);
/* 122 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 123 */     boolean isNull3 = true;
/* 124 */     java.lang.String value3 = null;
/* 125 */     if (!isNull4) {
/* 126 */
/* 127 */       isNull3 = false;
/* 128 */       if (!isNull3) {
/* 129 */
/* 130 */         Object funcResult1 = null;
/* 131 */         funcResult1 = value4.toString();
/* 132 */         value3 = (java.lang.String) funcResult1;
/* 133 */
/* 134 */       }
/* 135 */     }
/* 136 */     if (isNull3) {
/* 137 */       values[1] = null;
/* 138 */     } else {
/* 139 */       values[1] = value3;
/* 140 */     }
/* 141 */
/* 142 */   }
/* 143 */
/* 144 */
/* 145 */   private void apply_2(InternalRow i) {
/* 146 */
/* 147 */     boolean isNull10 = i.isNullAt(4);
/* 148 */     UTF8String value10 = isNull10 ? null : (i.getUTF8String(4));
/* 149 */     boolean isNull9 = true;
/* 150 */     java.lang.String value9 = null;
/* 151 */     if (!isNull10) {
/* 152 */
/* 153 */       isNull9 = false;
/* 154 */       if (!isNull9) {
/* 155 */
/* 156 */         Object funcResult4 = null;
/* 157 */         funcResult4 = value10.toString();
/* 158 */         value9 = (java.lang.String) funcResult4;
/* 159 */
/* 160 */       }
/* 161 */     }
/* 162 */     if (isNull9) {
/* 163 */       values[4] = null;
/* 164 */     } else {
/* 165 */       values[4] = value9;
/* 166 */     }
/* 167 */
/* 168 */     boolean isNull12 = i.isNullAt(5);
/* 169 */     UTF8String value12 = isNull12 ? null : (i.getUTF8String(5));
/* 170 */     boolean isNull11 = true;
/* 171 */     java.lang.String value11 = null;
/* 172 */     if (!isNull12) {
/* 173 */
/* 174 */       isNull11 = false;
/* 175 */       if (!isNull11) {
/* 176 */
/* 177 */         Object funcResult5 = null;
/* 178 */         funcResult5 = value12.toString();
/* 179 */         value11 = (java.lang.String) funcResult5;
/* 180 */
/* 181 */       }
/* 182 */     }
/* 183 */     if (isNull11) {
/* 184 */       values[5] = null;
/* 185 */     } else {
/* 186 */       values[5] = value11;
/* 187 */     }
/* 188 */
/* 189 */   }
/* 190 */
/* 191 */
/* 192 */   public java.lang.Object apply(java.lang.Object _i) {
/* 193 */     InternalRow i = (InternalRow) _i;
/* 194 */
/* 195 */     values = new Object[7];
/* 196 */     apply_0(i);
/* 197 */     apply_1(i);
/* 198 */     apply_2(i);
/* 199 */     apply_3(i);
/* 200 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 201 */     if (false) {
/* 202 */       mutableRow.setNullAt(0);
/* 203 */     } else {
/* 204 */
/* 205 */       mutableRow.update(0, value);
/* 206 */     }
/* 207 */
/* 208 */     return mutableRow;
/* 209 */   }
/* 210 */ }
