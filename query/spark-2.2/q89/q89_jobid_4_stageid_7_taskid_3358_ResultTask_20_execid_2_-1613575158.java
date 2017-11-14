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
/* 072 */   private void apply_0(InternalRow i) {
/* 073 */
/* 074 */     boolean isNull2 = i.isNullAt(0);
/* 075 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 076 */     boolean isNull1 = true;
/* 077 */     java.lang.String value1 = null;
/* 078 */     if (!isNull2) {
/* 079 */
/* 080 */       isNull1 = false;
/* 081 */       if (!isNull1) {
/* 082 */
/* 083 */         Object funcResult = null;
/* 084 */         funcResult = value2.toString();
/* 085 */         value1 = (java.lang.String) funcResult;
/* 086 */
/* 087 */       }
/* 088 */     }
/* 089 */     if (isNull1) {
/* 090 */       values[0] = null;
/* 091 */     } else {
/* 092 */       values[0] = value1;
/* 093 */     }
/* 094 */
/* 095 */     boolean isNull4 = i.isNullAt(1);
/* 096 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 097 */     boolean isNull3 = true;
/* 098 */     java.lang.String value3 = null;
/* 099 */     if (!isNull4) {
/* 100 */
/* 101 */       isNull3 = false;
/* 102 */       if (!isNull3) {
/* 103 */
/* 104 */         Object funcResult1 = null;
/* 105 */         funcResult1 = value4.toString();
/* 106 */         value3 = (java.lang.String) funcResult1;
/* 107 */
/* 108 */       }
/* 109 */     }
/* 110 */     if (isNull3) {
/* 111 */       values[1] = null;
/* 112 */     } else {
/* 113 */       values[1] = value3;
/* 114 */     }
/* 115 */
/* 116 */   }
/* 117 */
/* 118 */
/* 119 */   private void apply_2(InternalRow i) {
/* 120 */
/* 121 */     boolean isNull10 = i.isNullAt(4);
/* 122 */     UTF8String value10 = isNull10 ? null : (i.getUTF8String(4));
/* 123 */     boolean isNull9 = true;
/* 124 */     java.lang.String value9 = null;
/* 125 */     if (!isNull10) {
/* 126 */
/* 127 */       isNull9 = false;
/* 128 */       if (!isNull9) {
/* 129 */
/* 130 */         Object funcResult4 = null;
/* 131 */         funcResult4 = value10.toString();
/* 132 */         value9 = (java.lang.String) funcResult4;
/* 133 */
/* 134 */       }
/* 135 */     }
/* 136 */     if (isNull9) {
/* 137 */       values[4] = null;
/* 138 */     } else {
/* 139 */       values[4] = value9;
/* 140 */     }
/* 141 */
/* 142 */     boolean isNull11 = i.isNullAt(5);
/* 143 */     int value11 = isNull11 ? -1 : (i.getInt(5));
/* 144 */     if (isNull11) {
/* 145 */       values[5] = null;
/* 146 */     } else {
/* 147 */       values[5] = value11;
/* 148 */     }
/* 149 */
/* 150 */     boolean isNull12 = i.isNullAt(6);
/* 151 */     double value12 = isNull12 ? -1.0 : (i.getDouble(6));
/* 152 */     if (isNull12) {
/* 153 */       values[6] = null;
/* 154 */     } else {
/* 155 */       values[6] = value12;
/* 156 */     }
/* 157 */
/* 158 */     boolean isNull13 = i.isNullAt(7);
/* 159 */     double value13 = isNull13 ? -1.0 : (i.getDouble(7));
/* 160 */     if (isNull13) {
/* 161 */       values[7] = null;
/* 162 */     } else {
/* 163 */       values[7] = value13;
/* 164 */     }
/* 165 */
/* 166 */   }
/* 167 */
/* 168 */
/* 169 */   public java.lang.Object apply(java.lang.Object _i) {
/* 170 */     InternalRow i = (InternalRow) _i;
/* 171 */
/* 172 */     values = new Object[8];
/* 173 */     apply_0(i);
/* 174 */     apply_1(i);
/* 175 */     apply_2(i);
/* 176 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 177 */     if (false) {
/* 178 */       mutableRow.setNullAt(0);
/* 179 */     } else {
/* 180 */
/* 181 */       mutableRow.update(0, value);
/* 182 */     }
/* 183 */
/* 184 */     return mutableRow;
/* 185 */   }
/* 186 */ }
