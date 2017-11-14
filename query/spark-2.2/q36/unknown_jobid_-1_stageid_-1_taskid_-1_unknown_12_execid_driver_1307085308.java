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
/* 027 */     boolean isNull6 = i.isNullAt(4);
/* 028 */     double value6 = isNull6 ? -1.0 : (i.getDouble(4));
/* 029 */     if (isNull6) {
/* 030 */       values[4] = null;
/* 031 */     } else {
/* 032 */       values[4] = value6;
/* 033 */     }
/* 034 */
/* 035 */     long value7 = i.getLong(5);
/* 036 */     if (false) {
/* 037 */       values[5] = null;
/* 038 */     } else {
/* 039 */       values[5] = value7;
/* 040 */     }
/* 041 */
/* 042 */     UTF8String value9 = i.getUTF8String(6);
/* 043 */     boolean isNull8 = true;
/* 044 */     java.lang.String value8 = null;
/* 045 */     if (!false) {
/* 046 */
/* 047 */       isNull8 = false;
/* 048 */       if (!isNull8) {
/* 049 */
/* 050 */         Object funcResult1 = null;
/* 051 */         funcResult1 = value9.toString();
/* 052 */         value8 = (java.lang.String) funcResult1;
/* 053 */
/* 054 */       }
/* 055 */     }
/* 056 */     if (isNull8) {
/* 057 */       values[6] = null;
/* 058 */     } else {
/* 059 */       values[6] = value8;
/* 060 */     }
/* 061 */
/* 062 */     UTF8String value11 = i.getUTF8String(7);
/* 063 */     boolean isNull10 = true;
/* 064 */     java.lang.String value10 = null;
/* 065 */     if (!false) {
/* 066 */
/* 067 */       isNull10 = false;
/* 068 */       if (!isNull10) {
/* 069 */
/* 070 */         Object funcResult2 = null;
/* 071 */         funcResult2 = value11.toString();
/* 072 */         value10 = (java.lang.String) funcResult2;
/* 073 */
/* 074 */       }
/* 075 */     }
/* 076 */     if (isNull10) {
/* 077 */       values[7] = null;
/* 078 */     } else {
/* 079 */       values[7] = value10;
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
/* 108 */     boolean isNull3 = i.isNullAt(1);
/* 109 */     double value3 = isNull3 ? -1.0 : (i.getDouble(1));
/* 110 */     if (isNull3) {
/* 111 */       values[1] = null;
/* 112 */     } else {
/* 113 */       values[1] = value3;
/* 114 */     }
/* 115 */
/* 116 */     boolean isNull4 = i.isNullAt(2);
/* 117 */     double value4 = isNull4 ? -1.0 : (i.getDouble(2));
/* 118 */     if (isNull4) {
/* 119 */       values[2] = null;
/* 120 */     } else {
/* 121 */       values[2] = value4;
/* 122 */     }
/* 123 */
/* 124 */     boolean isNull5 = i.isNullAt(3);
/* 125 */     double value5 = isNull5 ? -1.0 : (i.getDouble(3));
/* 126 */     if (isNull5) {
/* 127 */       values[3] = null;
/* 128 */     } else {
/* 129 */       values[3] = value5;
/* 130 */     }
/* 131 */
/* 132 */   }
/* 133 */
/* 134 */
/* 135 */   private void apply_2(InternalRow i) {
/* 136 */
/* 137 */     UTF8String value13 = i.getUTF8String(8);
/* 138 */     boolean isNull12 = true;
/* 139 */     java.lang.String value12 = null;
/* 140 */     if (!false) {
/* 141 */
/* 142 */       isNull12 = false;
/* 143 */       if (!isNull12) {
/* 144 */
/* 145 */         Object funcResult3 = null;
/* 146 */         funcResult3 = value13.toString();
/* 147 */         value12 = (java.lang.String) funcResult3;
/* 148 */
/* 149 */       }
/* 150 */     }
/* 151 */     if (isNull12) {
/* 152 */       values[8] = null;
/* 153 */     } else {
/* 154 */       values[8] = value12;
/* 155 */     }
/* 156 */
/* 157 */   }
/* 158 */
/* 159 */
/* 160 */   public java.lang.Object apply(java.lang.Object _i) {
/* 161 */     InternalRow i = (InternalRow) _i;
/* 162 */
/* 163 */     values = new Object[9];
/* 164 */     apply_0(i);
/* 165 */     apply_1(i);
/* 166 */     apply_2(i);
/* 167 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 168 */     if (false) {
/* 169 */       mutableRow.setNullAt(0);
/* 170 */     } else {
/* 171 */
/* 172 */       mutableRow.update(0, value);
/* 173 */     }
/* 174 */
/* 175 */     return mutableRow;
/* 176 */   }
/* 177 */ }
