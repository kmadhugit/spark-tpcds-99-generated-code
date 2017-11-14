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
/* 073 */   private void apply_0(InternalRow i) {
/* 074 */
/* 075 */     boolean isNull2 = i.isNullAt(0);
/* 076 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 077 */     boolean isNull1 = true;
/* 078 */     java.lang.String value1 = null;
/* 079 */     if (!isNull2) {
/* 080 */
/* 081 */       isNull1 = false;
/* 082 */       if (!isNull1) {
/* 083 */
/* 084 */         Object funcResult = null;
/* 085 */         funcResult = value2.toString();
/* 086 */         value1 = (java.lang.String) funcResult;
/* 087 */
/* 088 */       }
/* 089 */     }
/* 090 */     if (isNull1) {
/* 091 */       values[0] = null;
/* 092 */     } else {
/* 093 */       values[0] = value1;
/* 094 */     }
/* 095 */
/* 096 */     boolean isNull4 = i.isNullAt(1);
/* 097 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 098 */     boolean isNull3 = true;
/* 099 */     java.lang.String value3 = null;
/* 100 */     if (!isNull4) {
/* 101 */
/* 102 */       isNull3 = false;
/* 103 */       if (!isNull3) {
/* 104 */
/* 105 */         Object funcResult1 = null;
/* 106 */         funcResult1 = value4.toString();
/* 107 */         value3 = (java.lang.String) funcResult1;
/* 108 */
/* 109 */       }
/* 110 */     }
/* 111 */     if (isNull3) {
/* 112 */       values[1] = null;
/* 113 */     } else {
/* 114 */       values[1] = value3;
/* 115 */     }
/* 116 */
/* 117 */   }
/* 118 */
/* 119 */
/* 120 */   private void apply_2(InternalRow i) {
/* 121 */
/* 122 */     boolean isNull11 = i.isNullAt(6);
/* 123 */     UTF8String value11 = isNull11 ? null : (i.getUTF8String(6));
/* 124 */     boolean isNull10 = true;
/* 125 */     java.lang.String value10 = null;
/* 126 */     if (!isNull11) {
/* 127 */
/* 128 */       isNull10 = false;
/* 129 */       if (!isNull10) {
/* 130 */
/* 131 */         Object funcResult3 = null;
/* 132 */         funcResult3 = value11.toString();
/* 133 */         value10 = (java.lang.String) funcResult3;
/* 134 */
/* 135 */       }
/* 136 */     }
/* 137 */     if (isNull10) {
/* 138 */       values[6] = null;
/* 139 */     } else {
/* 140 */       values[6] = value10;
/* 141 */     }
/* 142 */
/* 143 */     long value12 = i.getLong(7);
/* 144 */     if (false) {
/* 145 */       values[7] = null;
/* 146 */     } else {
/* 147 */       values[7] = value12;
/* 148 */     }
/* 149 */
/* 150 */   }
/* 151 */
/* 152 */
/* 153 */   public java.lang.Object apply(java.lang.Object _i) {
/* 154 */     InternalRow i = (InternalRow) _i;
/* 155 */
/* 156 */     values = new Object[8];
/* 157 */     apply_0(i);
/* 158 */     apply_1(i);
/* 159 */     apply_2(i);
/* 160 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 161 */     if (false) {
/* 162 */       mutableRow.setNullAt(0);
/* 163 */     } else {
/* 164 */
/* 165 */       mutableRow.update(0, value);
/* 166 */     }
/* 167 */
/* 168 */     return mutableRow;
/* 169 */   }
/* 170 */ }
